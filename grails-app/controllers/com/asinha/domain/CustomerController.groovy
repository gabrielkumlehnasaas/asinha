package com.asinha.domain
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController {

    def customerService

   def list() {
        [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }

    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }

    def create() {}

    def index() {}

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