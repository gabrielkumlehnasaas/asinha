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
        try {
            Payer payer = payerService.save(params)
            if (payer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, payerList: payerList, totalCount: payerList.size()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])   
    def show() {
        return [payer: Payer.get(params.long("payerId"))]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update() {
        try {
            Payer payer = payerService.update(params)
            if (payer) render ([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
