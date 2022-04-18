package com.asinha.domain

import com.asinha.domain.Payer

class PayerService {

    def getPayer(Integer id) {
        return Payer.get(id)
    }

    def index() {
        return Payer.getAll()
    }

    def save(Map params) {
        Payer payer = new Payer()
        payer.address = params.address
        payer.addressNumber = params.addressNumber
        payer.city = params.city
        payer.complement = params.complement
        payer.cpfCnpj = params.cpfCnpj
        payer.deleted = 0
        payer.email = params.email
        payer.phone = params.phone
        payer.name = params.name
        payer.postalCode = params.postalCode
        payer.province = params.province
        payer.state = params.state
        payer.save(failOnError: true)
        return payer
    }
}