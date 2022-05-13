package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PaymentController {

    def payerService
    def paymentService

    def create() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        try {Payment payment = paymentService.save(params)
            if(payment) render([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
