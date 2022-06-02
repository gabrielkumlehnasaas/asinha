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
        email email: true
    }
}
