package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer

import grails.converters.JSON

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class CustomerController extends BaseController {

    def customerService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {}
    
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        Customer customer = customerService.save(params)
        if(customer.hasErrors()) {
            List<String> errorMessages = []
            customer.errors.allErrors.each {
                errorMessages.add(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list() {
        return [customerList: Customer.list(max: getLimitPerPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show() {
        return [customer: Customer.get(params.long("customerId"))]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update() {
        Customer customer = customerService.update(params)
        if(customer.hasErrors()) {
            List<String> errorMessages = []
            customer.errors.allErrors.each {
                errorMessages.add(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
    }
}
