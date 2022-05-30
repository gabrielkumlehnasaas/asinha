package com.asinha.domain

import com.asinha.base.BaseController
import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class PaymentController extends BaseController{

    def payerService
    def paymentService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.getPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        try {
            Payment payment = paymentService.save(params)
            if(payment) render([success: true] as JSON)
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list() {
        Long customerId = params.long("customerId")
        List<Payment> paymentList = paymentService.getPaymentsByCustomer(customerId, getLimitPerPage(), getCurrentPage())
        return [customerId: customerId, paymentList: paymentList, totalCount: paymentList.size()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show() {
        return [payment: Payment.get(params.long("paymentId"))]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def confirm() {
        Long paymentId = params.long("paymentId")
        try {
            Payment payment = paymentService.confirmPayment(paymentId)
            if (payment) {
                render([success: true] as JSON) 
            }
        } catch (Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}
