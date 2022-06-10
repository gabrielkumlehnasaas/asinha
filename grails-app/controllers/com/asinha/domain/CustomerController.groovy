package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer
import com.asinha.utils.UserUtils
import com.asinha.domain.PaymentService

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN'])
class CustomerController extends BaseController {

    def customerService
    def paymentService

    def list() {
        return [customerList: Customer.list(max: getLimitPerPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    @Secured(['ROLE_USER'])
    def show() {
        User user = UserUtils.getCurrentUser()
        if ( user.isAdmin() && params.customerId) return [customer: Customer.get(params.long("customerId"))]
    
        return [customer: user.customer]
    }

    @Secured(['ROLE_USER'])
    def update() {
        Long customerId = UserUtils.getCurrentCustomerId()
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
