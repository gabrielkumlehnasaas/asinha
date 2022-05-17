package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod

import grails.converters.JSON

class PaymentController {

    def payerService
    def paymentService

    def create() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        try {
            Payment payment = paymentService.save(params)
            if(payment) render([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    def list() {
        Long customerId = params.long("customerId")
        List<Payment> paymentList = paymentService.getPaymentsByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, paymentList: paymentList, totalCount: paymentList.size()]
    }
}
