package com.asinha.utils

import com.asinha.domain.Customer
import com.asinha.domain.User

import grails.util.Holders

class UserUtils {

    public User getCurrentUser() {
        User user = User.get(Holders.applicationContext.springSecurityService.currentUserId)
        return user
    }

    public Customer getCurrentCustomer() {
        Customer customer = getCurrentUser().customer
        return customer
    }
    
    public Long getCurrentCustomerId() {
        Long customerId = getCurrentCustomer().id
        return customerId
    }
}
