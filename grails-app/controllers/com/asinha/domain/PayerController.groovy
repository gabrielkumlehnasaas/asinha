package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Payer

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class PayerController extends BaseController {

    def payerService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        return [customerId: params.long("customerId")]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        Payer payer = payerService.save(params)
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
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, payerList: payerList, totalCount: payerList.totalCount]
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
