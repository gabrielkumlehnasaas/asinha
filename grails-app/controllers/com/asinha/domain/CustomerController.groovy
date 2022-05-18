package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer

import grails.converters.JSON

class CustomerController extends BaseController {

    def customerService

    def index() {}

    def create() {}
    
    def save() {
        Customer customer = customerService.save(params)
        println(customer.hasErrors())
        if(customer.hasErrors()) {
            String errorMessages = ""
            customer.errors.allErrors.each {
                // errorMessages += it.message + "\n"
                println(it.defaultMessage)
            }
            render([success: false, message: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
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
            if (customer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
