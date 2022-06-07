package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.utils.DomainUtils
import com.asinha.utils.ValidationUtils

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer update(Long customerId, Map params) {
        Customer customer = Customer.get(customerId)
        customer = validate(customer, params)
        if (customer.hasErrors()) return customer
        customer.address = params.address
        customer.addressNumber = params.addressNumber
        customer.city = params.city
        customer.complement = params.complement
        customer.cpfCnpj = ValidationUtils.digitsOnlyCleaner(params.cpfCnpj)
        customer.email = params.email
        customer.phone = ValidationUtils.digitsOnlyCleaner(params.phone)
        customer.name = params.name
        customer.postalCode = ValidationUtils.digitsOnlyCleaner(params.postalCode)
        customer.province = params.province
        customer.state = params.state
        customer.save(flush: true, failOnError:true)
        return customer
        println "customer ${customer}"
    } 

    public Customer validate(Customer customer, Map params) {
        if (!ValidationUtils.validateNotNull(params.address)) DomainUtils.addError(customer, "Campo Endereço é obrigatório")
        if (!ValidationUtils.validateAddressNumber(params.addressNumber)) DomainUtils.addError(customer, "Número inválido")
        if (!ValidationUtils.validateNotNull(params.city)) DomainUtils.addError(customer, "Campo Cidade é obrigatório")
        if (!ValidationUtils.validateCpfCnpj(params.cpfCnpj)) DomainUtils.addError(customer, "CPF/CNPJ inválido")
        if (!ValidationUtils.validateEmail(params.email)) DomainUtils.addError(customer, "E-mail inválido")
        if (!ValidationUtils.validatePhone(params.phone)) DomainUtils.addError(customer, "Número de telefone inválido")
        if (!ValidationUtils.validateNotNull(params.name)) DomainUtils.addError(customer, "Campo Nome é obrigatório")
        if (!ValidationUtils.validatePostalCode(params.postalCode)) DomainUtils.addError(customer, "CEP inválido")
        if (!ValidationUtils.validateNotNull(params.province)) DomainUtils.addError(customer, "Campo Bairro é obrigatório")
        if (!ValidationUtils.validateNotNull(params.state)) DomainUtils.addError(customer, "Campo Estado é obrigatório")
        return customer
    }


}
