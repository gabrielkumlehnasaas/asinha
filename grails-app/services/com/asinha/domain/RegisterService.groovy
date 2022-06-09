package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.customUserDetails.CustomUserDetails
import com.asinha.domain.Role
import com.asinha.domain.User
import com.asinha.domain.UserRole

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured


@Transactional
@Secured('permitAll')
class RegisterService {

    public User register(Map params) {
        Customer customer = createCustomer(params.username)
        User user = createUser(params.username, params.password, customer)
        assignRoleUser(user)
        return user
    }

    public Customer createCustomer(String email) {
        Customer customer = new Customer()
        customer.email = email
        customer.save(flush: true, failOnError: true)
    }

    public User createUser() {
        User user = new User(String username, String password, Customer customer)
        user.username = username
        user.password = password
        user.customer = customer 
        user.save(flush: true)
        return user
    }

    public assignRoleUser(User user) {
        Role role = Role.get(2)
        UserRole.create(user, role)
        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
}
