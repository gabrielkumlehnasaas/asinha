package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gorm.transactions.Transactional
import grails.plugin.asyncmail.AsynchronousMailService
import java.math.BigDecimal

@Transactional
class PaymentService {

    grails.gsp.PageRenderer groovyPageRenderer
    AsynchronousMailService asyncMailService

    public List<Payment> getPaymentsByCustomer(Long customerId, Integer max, Integer offset) {
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
            subject "Confirmação de pagamento"
            html groovyPageRenderer.render(template: "/email/confirmPaymentCustomer", model: [payment: payment])
        }
        asyncMailService.sendMail {
            to payment.payer.email
            subject "Confirmação de pagamento"
            html groovyPageRenderer.render(template: "/email/confirmPaymentPayer", model: [payment: payment])
        }
        return payment
    }
    
    public List<Payment> listPaymentByStatusAndDate(PaymentStatus paymentStatus, Date yesterday) {
        List<Payment> paymentList= Payment.createCriteria().list() {
            eq("status", paymentStatus)
            and {
                like("dueDate", yesterday) 
            }
        }
        return paymentList
    }

    public List<Payment> listLastNewPaymentsByMin(PaymentStatus paymentStatus,Integer minutes) {
        Date minutesBefore = CustomDateUtils.getMinutesBefore(minutes)
        List<Payment> paymentList= Payment.createCriteria().list() {
            eq("status", paymentStatus)
            and {
                gt("dateCreated", minutesBefore) 
            }
        }
        return paymentList
    }

}
