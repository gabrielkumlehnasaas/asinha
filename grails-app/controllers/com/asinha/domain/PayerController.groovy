
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
        return [customerId: params.long("id")]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            if(payer) render ([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    def list() {
        Long customerId = params.long("id")
        def payerCriteria = Payer.createCriteria()
        def payerList = payerCriteria.list(max: 10, offset: getCurrentPage()) {
            like("customer", Customer.get(customerId))
        }
        [payerList: payerList, totalCount: Payer.count()]
    }
    



}