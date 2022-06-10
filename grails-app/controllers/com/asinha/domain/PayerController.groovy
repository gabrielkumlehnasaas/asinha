package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Payer
import com.asinha.utils.UserUtils

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class PayerController extends BaseController {

    def payerService

    def create() {}

    def save() {
        Long customerId = UserUtils.getCurrentCustomerId()
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

    def list() {
        Long customerId = UserUtils.getCurrentCustomerId()
        List<Payer> payerList = payerService.getPayersByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [payerList: payerList, totalCount: payerList.totalCount]
    }
 
    def show() {
        return [payer: Payer.get(params.long("payerId"))]
    }

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
