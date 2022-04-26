package com.asinha.domain

class Customer {

    String address
    String addressNumber
    String city
    String complement
    String cpfCnpj
    Boolean deleted = false
    Date dateCreated = new Date()
    Date lastUpdate = dateCreated
    Date dateDeleted
    String email
    String phone
    String name
    String postalCode
    String province
    String state

    static constraints = {
        address size: 1..255, nullable: false
        addressNumber size: 1..255, nullable: false
        city size: 1..255, nullable: false
        complement size: 1..255, nullable: true
        cpfCnpj size: 11..14, nullable: false
        deleted nullable: false
        dateCreated nullable: false
        lastUpdate nullable: false
        dateDeleted nullable: true
        email email: true, size: 5..255, nullable: false
        phone size: 1..255, nullable: false
        name size: 1..255, nullable: false
        postalCode size: 1..255, nullable: false
        province size: 1..255, nullable: false
        state size: 1..255, nullable: false
    }
}
