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
        try {
            Customer customer = customerService.save(params)
            if (customer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
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
        try {
            Customer customer = customerService.update(params)
            if (customer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
