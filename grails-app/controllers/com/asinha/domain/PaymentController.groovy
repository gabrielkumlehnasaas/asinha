package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PaymentController extends BaseController {

    def payerService
    def paymentService

    def create() {
        List<Payer> payerList = payerService.getPayersByCustomer(params.long("id"))
        return [customerId: params.long("id"), payerList: payerList]
    }

    def save() {
        try {Payment payment = paymentService.save(params)
            if(payment) render([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente. Erro: "+ exception.message] as JSON)
        }
    }

    def list() {
        List<Payment> paymentList = paymentService.getPaymentsByCustomer(params.long("id"), getLimitPerPage(), getCurrentPage())
        return [customerId: params.long("id"), paymentList: paymentList, totalCount: paymentList.size()]
    }

    def show() {
        return [payment: Payment.get(params.long("id"))]
    }
}
