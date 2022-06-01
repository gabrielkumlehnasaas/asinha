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
        address size: 1..255, nullable: true
        addressNumber size: 1..255, nullable: true
        city size: 1..255, nullable: true
        complement size: 1..255, nullable: true
        cpfCnpj size: 11..14, nullable: true
        email size: 5..255, nullable: false
        phone size: 1..255, nullable: true
        name size: 1..255, nullable: true
        postalCode size: 1..255, nullable: true
        province size: 1..255, nullable: true
        state size: 1..255, nullable: true
    }
    
    String toString() {}
    
}
