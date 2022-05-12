package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Payer

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PayerController extends BaseController {

    def payerService

    def index() {}

    def create() {
        return [customerId: params.long("customerId")]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            if(payer) render ([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente. Erro: "+ exception.message] as JSON)
        }
    }

    def list() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, payerList: payerList, totalCount: payerList.size()]
    }
    
    def show(){
        Long payerId = params.long("payerId")
        return [payer: Payer.get(payerId)]
    }

    def update() {
        try {
            Payer payer = payerService.update(params)
            if (payer) redirect([action: "show", payerId: payer.id])
        } catch(Exception exception) {
             render([success: false, message: "Erro, tente novamente. Erro: "+ exception.message] as JSON)
        }
    }
}