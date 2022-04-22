package com.asinha.domain
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController {

    def customerService

    def list() {
        Integer page = params.int("id")
        return [page: page, customerList: customerService.list(page), totalPages: customerService.countPages()]
    }

    def create() {
    }

    def save() {
        try {
            Customer customer = customerService.save(params)
            Integer listPage = Math.round(Math.ceil(customer.id/20))
            if(customer) {
                redirect(action: "list", id:listPage)
            }
        } catch(Exception exception) {
            println(exception)
        }
    }
}