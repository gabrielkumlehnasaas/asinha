package com.asinha.domain

import com.asinha.domain.User
import com.asinha.base.BaseController
import com.asinha.domain.Customer

import grails.converters.JSON

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.util.Holders



class CustomerController extends BaseController {


    def customerService
    
    Holders holders
    
  
    def springSecurityService


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {}

    @Secured(['ROLE_ADMIN'])
    def list() {
        return [customerList: Customer.list(max: getLimitPerPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show() {
        if(params.customerId) return [customer: Customer.get(params.long("customerId"))]
        Customer customer = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer
        return [customer: customer]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update() {
        Long customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        Customer customer = customerService.update(customerId, params)
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
