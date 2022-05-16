package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer

import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public List<Payer> getPayersByCustomer(customerId, max, offset) {
        List<Payer> payerCriteria = Payer.createCriteria().list(max: max, offset: offset) {
            eq("customer", Customer.get(customerId))
        }
        return payerList
    }

    public Payer save(Map params) {
        Payer payer = new Payer()
        payer.address = params.address
        payer.addressNumber = params.addressNumber
        payer.city = params.city
        payer.complement = params.complement
        payer.cpfCnpj = params.cpfCnpj
        payer.email = params.email
        payer.phone = params.phone
        payer.name = params.name
        payer.postalCode = params.postalCode
        payer.province = params.province
        payer.state = params.state
        payer.customer = Customer.get(params.long("customerId"))
        payer.save(failOnError: true)
        return payer
    }
}
