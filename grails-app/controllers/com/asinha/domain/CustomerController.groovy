package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer
import com.asinha.domain.PaymentService

import grails.converters.JSON

class CustomerController extends BaseController {

    def customerService
    def paymentService

    def index() {}

    def create() {}
    
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

    def list() {
        return [customerList: Customer.list(max: getLimitPerPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    def show() {
        Long customerId = params.long("customerId")
        Map dashboard = paymentService.getDashboardInfo(customerId) 
        return [customer: Customer.get(customerId), dashboard: dashboard]
    }

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
