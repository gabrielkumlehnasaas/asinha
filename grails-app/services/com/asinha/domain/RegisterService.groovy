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

    def index() {}

    def register() {
        if(!params.password.equals(params.repassword)) {
            flash.message = "Senha e confirmação de senha não coincidem"
            redirect action: "index"
            return
        }
        try {
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
            flash.message = "Você se registrou com sucesso. Por favor entre."
            redirect controller: "login", action: "auth"

        } catch (Exception e) {
            e.printStackTrace()
            flash.message = "Falha no registro"
            redirect action: "index"
            return
        }
    }

    def User update(Map params) {
        User user = User.get(params.long("userId"))
        user.username = params.username
        user.password = params.password
        user.fullname = params.fullname
        user.customer = customer
        user.save()
    }











}