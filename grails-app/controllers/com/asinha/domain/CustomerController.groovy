package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import static org.springframework.validation.Errors.*

class CustomerController extends BaseController {

    def customerService

    def index() {}

    def create() {}
    
    def save() {
        try {
            Customer customer = customerService.save(params)
            if(customer) render ([success: true] as JSON)
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente. Erro: "+ exception.message] as JSON)
        }
    }

    def list() {
        return [customerList: Customer.list(max: getLimitPerPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    def show() {
        return [customer: Customer.get(params.long("customerId"))]
    }

    def update() {
        try {
            Customer customer = customerService.update(params)
            if (customer) redirect([action: "show", customerId: customer.id])
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente. Erro: "+ exception.message] as JSON)            
        }
    }
}
