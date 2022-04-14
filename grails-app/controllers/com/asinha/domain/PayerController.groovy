package com.asinha.domain
import com.asinha.domain.Payer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON


class PayerController {

    def payerService

    def list() {
        return [customerList: payerService.list()]
    }

    def create() {
    }

    def show() {
        return [payer: payerService.getpayer(params.int(id))]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            if(payer) {
                redirect(action: "list")
            }
        } catch(Exception exception) {
            println(exception)
        }
    }
}
