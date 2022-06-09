package com.asinha.utils

import com.asinha.domain.User

import grails.util.Holders

class UserUtils() {

    public Long getUsersCustomerId() {
        customerId = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer.id
        return customerId
    }

    public Customer getUsersCustomer() {
        customer = User.get(Holders.applicationContext.springSecurityService.currentUserId).customer
        return customer
    }
}