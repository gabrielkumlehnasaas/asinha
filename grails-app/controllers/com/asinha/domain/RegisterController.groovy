package com.asinha.domain

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import com.asinha.domain.User
import com.asinha.domain.Role
import com.asinha.domain.Customer
import com.asinha.domain.UserRole
import com.asinha.customUserDetails.CustomUserDetails

@Transactional
@Secured('permitAll')
class RegisterController {

    def registerService

    static allowedMethods = [register: "POST"]

    def index() {}

    def register() {
        try {
            if(!params.password.equals(params.repassword)) {
                flash.message = "Senha e confirmação de senha não coincidem"
                redirect action: "index"
                return
            }
            registerService.register(params)
            flash.message = "Você se registrou com sucesso. Por favor entre."
            redirect controller: "login", action: "auth"

        } catch (Exception e) {
            e.printStackTrace()
            flash.message = "Falha no registro"
            redirect action: "index"
            return
        }
    } 
}