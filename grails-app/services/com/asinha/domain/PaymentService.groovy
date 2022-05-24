package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.PayerService
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gorm.transactions.Transactional
import grails.plugin.asyncmail.AsynchronousMailService
import java.math.BigDecimal

@Transactional
class PaymentService {

    def payerService
    grails.gsp.PageRenderer groovyPageRenderer
    AsynchronousMailService asyncMailService

    public String getString() {
        return "importei o service de payment"
    }

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
        asyncMailService.sendMail {
            to payment.customer.email
            subject "Notificação de nova cobrança"
            html groovyPageRenderer.render(template: "/email/newPaymentCustomer", model: [payment: payment])
        }
        asyncMailService.sendMail {
            to payment.payer.email
            subject "Notificação de nova cobrança"
            html groovyPageRenderer.render(template: "/email/newPaymentPayer", model: [payment: payment])
        }
        return payment
    }

    public Payment confirmPayment(paymentId) {
        Payment payment = Payment.get(paymentId)
        payment.status = PaymentStatus.PAID
        payment.paymentDate = new Date()
        payment.lastUpdate = new Date()
        payment.save(flush: true, failOnError:true)
        asyncMailService.sendMail {
            to payment.customer.email
            subject "Notificação de pagamento"
            html groovyPageRenderer.render(template: "/email/confirmPaymentCustomer", model: [payment: payment])
        }
        asyncMailService.sendMail {
            to payment.payer.email
            subject "Notificação de pagamento"
            html groovyPageRenderer.render(template: "/email/confirmPaymentPayer", model: [payment: payment])
        }
        return payment
    }
    
    public List<Payment> listPaymentByStatusAndDate(PaymentStatus paymentStatus, Date date) {
        List<Payment> paymentList = Payment.createCriteria().list() {
            eq("status", paymentStatus)
            and {
                like("dueDate", date) 
            }
        }
        return paymentList
    }

    public List<Payment> listPaymentByCustomerAndStatus(Long customerId, PaymentStatus paymentStatus) {
        List<Payment> paymentList = Payment.createCriteria().list() {
            eq("customer", Customer.get(customerId))
            and {
                eq("status", paymentStatus)
            }
        }
        return paymentList
    }

    public BigDecimal sumOfValuesInList(List<Payment> paymentList) {
        BigDecimal totalValue = 0.00
        paymentList.forEach() {
            totalValue += it.value
        }
        return totalValue
    }

    public Map getDashboardInfo(Long customerId) {
        if (getPaymentsByCustomer(customerId)) {

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

            BigDecimal recieved = sumOfValuesInList(listPaymentByCustomerAndStatus(customerId, PaymentStatus.PAID))
            BigDecimal foreseen = sumOfValuesInList(listPaymentByCustomerAndStatus(customerId, PaymentStatus.PENDING))
            BigDecimal overdue = sumOfValuesInList(overduePaymentList)

            return [totalPayers: totalPayers, defaulters: defaulters, nonDefaulters: nonDefaulters, recieved: recieved, foreseen: foreseen, overdue: overdue]
        return null
        }
    }
}
