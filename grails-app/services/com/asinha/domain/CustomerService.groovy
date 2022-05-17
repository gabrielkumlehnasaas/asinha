package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.utils.DomainUtils

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer update(Map params) {
        Customer customer = Customer.get(params.long("customerId"))
        validate(customer, params)
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
        customer = validate(customer, params)
        if(customer.hasErrors()) return customer
        customer.address = params.address
        customer.addressNumber = params.addressNumber.replaceAll("[^0-9]", '')
        customer.city = params.city
        customer.complement = params.complement
        customer.cpfCnpj = params.cpfCnpj.replaceAll("[^0-9]", '')
        customer.email = params.email
        customer.phone = params.phone
        customer.name = params.name
        customer.postalCode = params.postalCode
        customer.province = params.province
        customer.state = params.state
        customer.save(failOnError: true)
        return customer
    }

    public Customer validate(Customer customer, Map params) {
        if(!DomainUtils.addressNumberValidate(params.addressNumber)) {
            DomainUtils.addError(customer, "Endereço sem número"))
        }
        if (!DomainUtils.phoneValidate(params.phone)) {
            DomainUtils.addError(customer, "Número de telefone inválido")
        }
        if (!DomainUtils.cpfCnpjValidate(params.cpfCnpj)) {
            DomainUtils.addError(customer, "CPF/CNPJ inválido")
        }
        if (!DomainUtils.postalCodeValidate(params.postalCode)) {
            DomainUtils.addError(customer, "CEP inválido")
        }
        return customer
    }
}
