package com.asinha.domain

import grails.gorm.services.Service
import com.asinha.domain.Customer.*

Customer

@Service(Customer)
class CustomerService {

    Customer get(Serializable id)

    List<Customer> list(Map args)

    Long count()

    def save(Customer customer) {
        customer.save(failOnError: true)
    }

}