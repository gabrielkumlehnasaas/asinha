package com.asinha.domain
import com.asinha.domain.Payer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PayerController {

    def payerService

    def index() {
        return [payerList: payerService.list()]
    }

    def create() {
        Integer id = params.int("id")
        return [customerId: id]
    }

    def save(Map params) {
        try {Payer payer = payerService.save(params)
            if(payer) {
                render([success: true])
            }
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}