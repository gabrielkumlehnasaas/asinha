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
        try {
            Customer customer = customerService.save(params)
            if (customer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
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
        try {
            Customer customer = customerService.update(params)
            if (customer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
