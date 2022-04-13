package com.asinha.domain

import com.asinha.domain.Customer

class CustomerService {

    def list() {
        return Customer.list()
    }

    def save(Map params) {
        Customer customer = new Customer()
        customer.address = params.address
        customer.addressNumber = params.addressNumber
        customer.city = params.city
        customer.complement = params.complement
        customer.cpfCnpj = params.cpfCnpj
        customer.deleted = 0
        customer.email = params.email
        customer.phone = params.phone
        customer.name = params.name
        customer.postalCode = params.postalCode
        customer.province = params.province
        customer.state = params.state
        if(params.cpfCnpj.length() == 11) {
            customer.birthDate = params.birthDate
        }
        customer.save(failOnError: true)
        return customer
    }
}