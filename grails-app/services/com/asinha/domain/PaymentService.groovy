package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.EmailService
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils
import com.asinha.utils.DomainUtils
import com.asinha.utils.ValidationUtils

import grails.gsp.PageRenderer
import grails.gorm.transactions.Transactional
import java.math.BigDecimal

@Transactional
class PaymentService {

    PageRenderer groovyPageRenderer
    def emailService

    public List<Payment> getPaymentsByCustomer(Long customerId, Integer max, Integer offset) {
        List<Payment> paymentList = Payment.createCriteria().list(max: max, offset: offset) {
            eq("customer", Customer.get(customerId))
        }
        return paymentList
    }

    public Payment save(Map params) {
        Payment payment = new Payment()
        payment = validate(payment, params)
        if (payment.hasErrors()) return payment
        
        payment.value = new BigDecimal(params.value.replaceAll(",", ""))
        payment.description = params.description
        payment.method = PaymentMethod.valueOf(params.method) 
        payment.status = PaymentStatus.PENDING
        payment.dueDate = CustomDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.save(failOnError: true)
        notifyNewPayment(payment.id)
        return payment
    }

    public Payment confirmPayment(Long paymentId) {
        Payment payment = Payment.get(paymentId)
        payment.status = PaymentStatus.PAID
        payment.paymentDate = new Date()
        payment.save(flush: true, failOnError:true)
        notifyConfirmedPayment(paymentId)
        return payment
    }

    public Payment validate(Payment payment, Map params) {
        if (!validateValue(params.value)) DomainUtils.addError(payment, 'Cobrança mínima de R$5.00')
        if (!ValidationUtils.validateNotNull(params.description)) DomainUtils.addError(payment, "Campo Cidade é obrigatório")
        if (!validateMethod(params.method)) DomainUtils.addError(payment, "Método de pagamento inválido")
        if (!validateDueDate(params.dueDate)) DomainUtils.addError(payment, "Data de vencimento inválida")
        return payment
    }

    private static Boolean validateValue(String value) {
        BigDecimal parsedValue = new BigDecimal(value.replaceAll(",", ""))
        if (parsedValue < 5.00) {
            return false
            }
        return true
    }

    private static Boolean validateMethod(String method) {
        return PaymentMethod.values().contains(PaymentMethod.valueOf(method))
    }

    private static Boolean validateDueDate(String dueDate) {
        if (CustomDateUtils.toDate(dueDate, "yyyy-MM-dd") < new Date()) {
            return false
        }
        return true
    }
    
    public List<Payment> listPaymentByStatusAndDate(PaymentStatus paymentStatus, Date date) {
        Date beginningOfDay = date.clearTime()
        Date endOfDay = CustomDateUtils.getEndOfDay(date) 
        List<Payment> paymentList= Payment.createCriteria().list() {
            eq("status", paymentStatus)
            and {
                ge("dueDate", beginningOfDay)
                le("dueDate", endOfDay)
            }
        }
        return paymentList
    }

    public void updateOverduePayments() {
        Date today = new Date()
        Date yesterday = CustomDateUtils.sumDays(today, (-1))
        List<Payment> paymentList = listPaymentByStatusAndDate(PaymentStatus.PENDING, yesterday)
        for(Payment payment : paymentList) {
            payment.status = PaymentStatus.OVERDUE
            payment.save(flush: true)
        }
    }

    private void notifyNewPayment(Long paymentId) {
        Payment payment = Payment.get(paymentId)
        String subject = "Notificação de nova cobrança"
        emailService.sendEmail(payment.customer.email, subject, groovyPageRenderer.render(template: "/email/newPaymentCustomer", model: [payment: payment]))
        emailService.sendEmail(payment.payer.email, subject, groovyPageRenderer.render(template: "/email/newPaymentPayer", model: [payment: payment]))
    }

    private void notifyConfirmedPayment(Long paymentId) {
        Payment payment = Payment.get(paymentId)
        String subject = "Notificação de pagamento"
        emailService.sendEmail(payment.customer.email, subject, groovyPageRenderer.render(template: "/email/confirmPaymentCustomer", model: [payment: payment]))
        emailService.sendEmail(payment.payer.email, subject, groovyPageRenderer.render(template: "/email/confirmPaymentPayer", model: [payment: payment]))
    }
}
