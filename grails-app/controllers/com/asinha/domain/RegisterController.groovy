package com.asinha.domain

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import com.asinha.domain.User
import com.asinha.domain.Role
import com.asinha.domain.UserRole
import com.asinha.customUserDetails.CustomUserDetails

@Transactional
@Secured('permitAll')
class RegisterController {

    static allowedMethods = [register: "POST"]

    def index() { }

    def register() {
        if(!params.password.equals(params.repassword)) {
            flash.message = "Senha e confirmação de senha não coincidem"
            redirect action: "index"
            return
        } else {
            try {
                def user = User.findByUsername(params.username)?: new User(username: params.username, password: params.password, fullname: params.fullname).save()
                def role = Role.get(2)

                if(user && role) {
                    UserRole.create user, role

                    UserRole.withSession {
                      it.flush()
                      it.clear()
                    }

                    flash.message = "Você se registrou com sucesso. Por favor entre."
                    redirect controller: "login", action: "auth"
                } else {
                    flash.message = "Falha no registro"
                    render view: "index"
                    return
                }
            } catch (ValidationException e) {
                flash.message = "Falha no registro"
                redirect action: "index"
                return
            }
        }
    }
}