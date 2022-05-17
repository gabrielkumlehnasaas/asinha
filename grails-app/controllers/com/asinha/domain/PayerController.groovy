package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Payer

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PayerController extends BaseController {

    def payerService

    def create() {
        return [customerId: params.long("customerId")]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            if (payer) render ([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    def list() {
        List<Payer> payerList = payerService.getPayersByCustomer(params.long("customerId"), getLimitPerPage(), getCurrentPage())
        return [payerList: payerList, totalCount: payerList.size()]
    }
    
    def show() {
        return [payer: Payer.get(params.long("payerId"))]
    }

    def update() {
        try {
            Payer payer = payerService.update(params)
            if (payer) render ([success: true] as JSON)
        } catch(Exception exception) {
             render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
