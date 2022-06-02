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

    def register() {} 
}