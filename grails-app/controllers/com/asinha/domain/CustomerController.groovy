package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CustomerController extends BaseController {

    def customerService

    def list() {
        [customerService.list()]
    }

    def create() {}

    def index() {}

    def save() {
        try {
            Customer customer = customerService.save(params)
            if(customer) render ([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}