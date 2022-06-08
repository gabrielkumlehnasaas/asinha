package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod

import grails.converters.JSON

class PaymentController extends BaseController{

    def payerService
    def paymentService

    def create() {
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        return [payerList: payerList]
    }

    def save() {
        Long customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        Payment payment = paymentService.save(customerId, params)
        if (payment.hasErrors()) {
            List<String> errorMessages = []
            payment.errors.allErrors.each {
                errorMessages.add(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render([success: true] as JSON)
    }

    def list() {
        Long customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        List<Payment> paymentList = paymentService.getPaymentsByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [paymentList: paymentList, totalCount: paymentList.size()]
    }

    def show() {
        return [payment: Payment.get(params.long("paymentId"))]
    }

    def confirm() {
        Long paymentId = params.long("paymentId")
        try {
            Payment payment = paymentService.confirmPayment(paymentId)
            if (payment) {
                render([success: true] as JSON) 
            }
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
