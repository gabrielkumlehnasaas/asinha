package com.asinha.domain
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
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
                redirect(action: "index")
            }
        } catch(Exception exception) {
            println(exception)
        }
    }
}
