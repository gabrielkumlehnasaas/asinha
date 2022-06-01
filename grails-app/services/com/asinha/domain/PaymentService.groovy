package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.EmailService
import com.asinha.domain.Payer
import com.asinha.domain.PayerService
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gsp.PageRenderer
import grails.gorm.transactions.Transactional
import java.math.BigDecimal

@Transactional
class PaymentService {

    def payerService
    PageRenderer groovyPageRenderer
    def emailService

    public List<Payment> getPaymentsByCustomer(Long customerId, Integer max = null, Integer offset = null) {
        if (max == null || offset == null) {
            List<Payment> paymentList = Payment.createCriteria().list() {
                eq("customer", Customer.get(customerId))
            }
            return paymentList
        }
        List<Payment> paymentList = Payment.createCriteria().list(max: max, offset: offset) {
            eq("customer", Customer.get(customerId))
        }
        return paymentList
    }

    public Payment save(Map params) {
        Payment payment = new Payment()
        payment.value = new BigDecimal(params.value)
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
    
    public List<Payment> listPaymentByStatusAndDate(PaymentStatus paymentStatus, Date date) {
        Date beginningOfDay = CustomDateUtils.clearTime(date)
        Date endOfday = CustomDateUtils.getEndOfDay(date) 
        List<Payment> paymentList= Payment.createCriteria().list() {
            eq("status", paymentStatus)
            and {
                ge("dueDate", beginningOfDay)
                le("dueDate", endOfday)
            }
        }
        return paymentList
    }

    public void updateOverduePayments() {
        Date yesterday = CustomDateUtils.sumDays(new Date (-1))
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

    public Map getDashboardInfo(Long customerId) {
        if (!getPaymentsByCustomer(customerId)) return null
        
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        Integer totalPayers = payerList.size()
        
        List<Payment> overduePaymentList = listPaymentByCustomerAndStatus(customerId, PaymentStatus.OVERDUE)
        List<Payer> defaultersList = new ArrayList<Payer>()
        overduePaymentList.forEach() {
            if (!defaultersList.includes(it.payer))
            defaultersList.push(it.payer)
        }
        Integer defaulters = defaultersList.size()
        Integer nonDefaulters = totalPayers - defaulters

        BigDecimal received = listPaymentByCustomerAndStatus(customerId, PaymentStatus.PAID).value.sum()
        BigDecimal foreseen = listPaymentByCustomerAndStatus(customerId, PaymentStatus.PENDING).value.sum()
        BigDecimal overdue = overduePaymentList

        return [totalPayers: totalPayers, defaulters: defaulters, nonDefaulters: nonDefaulters, received: received, foreseen: foreseen, overdue: overdue]
    }
}
