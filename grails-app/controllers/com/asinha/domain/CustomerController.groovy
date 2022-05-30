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
        if(customer.hasErrors()) {
            List<String> errorMessages = []
            customer.errors.allErrors.each {
                errorMessages.push(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
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
        Customer customer = customerService.update(params)
        if(customer.hasErrors()) {
            List errorMessages = []
            customer.errors.allErrors.each {
                errorMessages.push(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
    }
}
