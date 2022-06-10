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
        // email email: true
        address nullable: true
        addressNumber nullable: true
        city nullable: true
        complement nullable: true
        cpfCnpj nullable: true
        phone nullable: true
        name nullable: true
        postalCode nullable: true
        province nullable: true
        state nullable: true
    }
}
