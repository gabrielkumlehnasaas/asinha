package com.asinha.domain

import grails.gorm.transactions.Transactional
import com.asinha.domain.Payer

@Transactional
class PayerService {

    def getPayer(Integer id) {
        return Payer.get(id)
    }

    def save(Map params) {
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer
    }

    def update(Map params) {
        Payer payer = Payer.get(params.int("id"))
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
        payer.lastUpdate = new Date()
        payer.save(flush: true, failOnError:true)
        return payer
    }
}