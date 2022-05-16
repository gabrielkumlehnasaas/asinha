package com.asinha.domain

import com.asinha.base.BaseEntity
import com.asinha.domain.Customer

class Payer extends BaseEntity {

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

    Customer customer

    static constraints = {
        address nullable: false
        addressNumber nullable: false
        city nullable: false
        complement nullable: true
        cpfCnpj size: 11..14, nullable: false
        email email: true, nullable: false
        phone nullable: false
        name nullable: false
        postalCode nullable: false
        province nullable: false
        state nullable: false
        customer nullable: false
    }
}
