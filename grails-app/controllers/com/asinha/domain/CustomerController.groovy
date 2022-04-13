package com.asinha.domain

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
            customerService.save(params)
            redirect(action: "index")
        } catch(Exception exception) {
            println(exception)
        }
    }
}
