package com.asinha.domain

import com.asinha.domain.Customer

class CustomerService {

    Integer totalListed = 10

    def list(page) {
        Integer offset = (page-1)*(totalListed)
        return Customer.list(max:totalListed, offset:offset)
    }

    def countPages() {
        Integer customerCount = Customer.getAll().size()
        return Math.round(Math.ceil(customerCount/totalListed))
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
        customer.save(failOnError: true)
        return customer
    }
}