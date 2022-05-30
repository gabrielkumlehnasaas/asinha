package com.asinha.domain

import com.asinha.base.BaseEntity

class Customer extends BaseEntity{

    String address

    String addressNumber

    String city

    String complement

    String cpfCnpj

    String email

    String phone

    String name

    String postalCode

    String province
    
    String state

    static constraints = {
        complement nullable: true
        email email: true
    }
}
