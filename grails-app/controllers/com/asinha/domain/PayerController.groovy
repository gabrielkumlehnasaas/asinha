package com.asinha.domain
import com.asinha.domain.Payer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PayerController {

    def index() {
        return [payerList: payerService.list()]
    }

    def create(Map params) {
        println(params)
        var customer = params.customer
        return [customer: customer]

    }

    def save() {
        try Payer payer = payerService.save(params)
            if(payer) {
                render([success: true])
            }
        catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}