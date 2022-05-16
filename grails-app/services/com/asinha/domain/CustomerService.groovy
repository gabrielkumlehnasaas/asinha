package com.asinha.domain

import com.asinha.domain.Customer

class CustomerService {

    public Customer save(Map params) {
        Customer customer = new Customer()
        customer.address = params.address
        customer.addressNumber = params.addressNumber
        customer.city = params.city
        customer.complement = params.complement
        customer.cpfCnpj = params.cpfCnpj
        customer.email = params.email
        customer.phone = params.phone
        customer.name = params.name
        customer.postalCode = params.postalCode
        customer.province = params.province
        customer.state = params.state
        customer.save(failOnError: true)
        return customer
    }
}
