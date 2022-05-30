package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.utils.DomainUtils
import com.asinha.utils.ValidationUtils

import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public List<Payer> getPayersByCustomer(Long customerId, Integer max = null, Integer offset = null) {
        def payerCriteria = Payer.createCriteria()
        if (max == null || offset == null) {
            List<Payer> payerList = payerCriteria.list() {
                eq("customer", Customer.get(customerId))
            }
            return payerList
        }
        List<Payer> payerList = payerCriteria.list(max: max, offset: offset) {
            eq("customer", Customer.get(customerId))
        }
        return payerList
    }

    public Payer save(Map params) {
        Payer payer = new Payer()
        payer = validate(payer, params)
        if (payer.hasErrors()) return payer
        payer.address = params.address
        payer.addressNumber = params.addressNumber
        payer.city = params.city
        payer.complement = params.complement
        payer.cpfCnpj = ValidationUtils.digitsOnlyCleaner(params.cpfCnpj)
        payer.email = params.email
        payer.phone = ValidationUtils.digitsOnlyCleaner(params.phone)
        payer.name = params.name
        payer.postalCode = ValidationUtils.digitsOnlyCleaner(params.postalCode)
        payer.province = params.province
        payer.state = params.state
        payer.customer = Customer.get(params.long("customerId"))
        payer.save(failOnError: true)
        return payer
    }   

    public Payer update(Map params) {
        Payer payer = Payer.get(params.long("payerId"))
        payer = validate(payer, params)
        if (payer.hasErrors()) return payer
        payer.address = params.address
        payer.addressNumber = params.addressNumber
        payer.city = params.city
        payer.complement = params.complement
        payer.cpfCnpj = ValidationUtils.digitsOnlyCleaner(params.cpfCnpj)
        payer.email = params.email
        payer.phone = ValidationUtils.digitsOnlyCleaner(params.phone)
        payer.name = params.name
        payer.postalCode = ValidationUtils.digitsOnlyCleaner(params.postalCode)
        payer.province = params.province
        payer.state = params.state
        payer.save(flush: true, failOnError:true)
        return payer
    }

    public Payer validate(Payer payer, Map params) {
        if (!(ValidationUtils.validateNotNull(params.address))) DomainUtils.addError(payer, "Campo Endereço é obrigatório")
        if (!(ValidationUtils.validateAddressNumber(params.addressNumber))) DomainUtils.addError(payer, "Número inválido")
        if (!(ValidationUtils.validateNotNull(params.city))) DomainUtils.addError(payer, "Campo Cidade é obrigatório")
        if (!(ValidationUtils.validateCpfCnpj(params.cpfCnpj))) DomainUtils.addError(payer, "CPF/CNPJ inválido")
        if (!(ValidationUtils.validateEmail(params.email))) DomainUtils.addError(payer, "E-mail inválido")
        if (!(ValidationUtils.validatePhone(params.phone))) DomainUtils.addError(payer, "Número de telefone inválido")
        if (!(ValidationUtils.validateNotNull(params.name))) DomainUtils.addError(payer, "Campo Nome é obrigatório")
        if (!(ValidationUtils.validatePostalCode(params.postalCode))) DomainUtils.addError(payer, "CEP inválido")
        if (!(ValidationUtils.validateNotNull(params.province))) DomainUtils.addError(payer, "Campo Bairro é obrigatório")
        if (!(ValidationUtils.validateNotNull(params.state))) DomainUtils.addError(payer, "Campo Estado é obrigatório")
        return  payer
    }
}
