package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Payer

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.util.Holders
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PayerController extends BaseController {

    def payerService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        Long customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        Payer payer = payerService.save(customerId, params)
        if (payer.hasErrors()) {
            List<String> errorMessages = []
            payer.errors.allErrors.each {
                errorMessages.add(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list() {
        Long customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        List<Payer> payerList = payerService.getPayersByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [payerList: payerList, totalCount: payerList.totalCount]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER']) 
    def show() {
        return [payer: Payer.get(params.long("payerId"))]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update() {
        Payer payer = payerService.update(params)
        if (payer.hasErrors()) {
            List errorMessages = []
            payer.errors.allErrors.each {
                errorMessages.push(it.defaultMessage)
            }
            render([success: false, messages: errorMessages] as JSON)
            return
        }
        render ([success: true] as JSON)
    }
}
