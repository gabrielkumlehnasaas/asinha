package com.asinha.domain

import grails.gorm.transactions.Transactional
import com.asinha.domain.Payer

@Transactional
class PayerService {

    def list() {
        return Payer.getAll()
    }

    def save(Map params) {
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer
    }
}