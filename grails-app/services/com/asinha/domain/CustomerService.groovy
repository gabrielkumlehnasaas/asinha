package com.asinha.domain

import com.asinha.domain.Customer

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer update(Map params) {
        println(params)
        Customer customer = Customer.get(params.long("customerId"))
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
        customer.lastUpdate = new Date()
        customer.save(flush: true, failOnError:true)
        return customer
    } 

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
