package com.asinha.domain
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController {

    def customerService

    def list() {
        return [customerList: customerService.list()]
    }

    def create() {
    }

    def show() {
        Integer id = params.int("id")
        return [customer: customerService.getCustomer(id)]
    }

    def edit() {
        Integer id = params.int("id")
        return [customer: customerService.getCustomer(id)]
    }

    def save() {
        try {
            Customer customer = customerService.save(params)
            if(customer) {
                redirect(action: "list")
            }
        } catch(Exception exception) {
            println(exception)
        }
    }
}