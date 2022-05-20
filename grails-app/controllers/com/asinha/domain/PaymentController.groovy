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
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        Payment payment = paymentService.save(params)
            if(payment.hasErrors()) {
                List errorMessages = []
                payment.errors.allErrors.each {
                    errorMessages.push(it.defaultMessage)
                }
                render([success: false, messages: errorMessages] as JSON)
                return
            }
        render([success: true] as JSON)
    }

    def list() {
        Long customerId = params.long("customerId")
        List<Payment> paymentList = paymentService.getPaymentsByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, paymentList: paymentList, totalCount: paymentList.size()]
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
