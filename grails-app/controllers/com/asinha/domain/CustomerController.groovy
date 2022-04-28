package com.asinha.domain
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import static org.springframework.validation.Errors.*
import grails.converters.JSON

class CustomerController {

    def customerService

    def index() {
        return [customerList: customerService.list()]
    }

    def create() {
    }

    def save() {
        try {
            Customer customer = customerService.save(params)
            if(customer) {
                render([success: true])
            }
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}