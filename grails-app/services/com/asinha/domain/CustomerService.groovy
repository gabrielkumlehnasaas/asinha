package com.asinha.domain

import com.asinha.domain.Customer

class CustomerService {

    def list() {
        return Customer.getAll()
    }

    def save(Map params) {
        Customer customer = new Customer(params)
        customer.save(failOnError: true)
        return customer
    }
}