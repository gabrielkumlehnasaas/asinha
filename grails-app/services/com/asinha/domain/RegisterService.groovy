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

    public register(Map params){
        Customer customer = new Customer()
        customer.email = params.username
        customer.save()
        println "customer ${customer}"

        User user = new User()
        user.username = params.username
        user.password = params.password
        user.fullname = params.fullname
        user.customer = customer
        user.save()

        def role = Role.get(2)

        UserRole.create user, role
        println "user ${user}"

        UserRole.withSession {
            it.flush()
            it.clear()
        }
        return User
    }












}