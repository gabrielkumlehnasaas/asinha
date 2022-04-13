package com.asinha.domain

class Customer {

    String address
    String addressNumber
    String city
    String complement
    String cpfCnpj
    int deleted
    String email
    Date dateCreated
    Date lastUpdate
    float creditCardLimit
    String phone
    String name
    String postalCode
    String province
    String state
    Date birthDate

    static constraints = {
        address size: 1..255, nullable: false
        addressNumber size: 1..255, nullable: false
        city size: 1..255, nullable: false
        complement size: 1..255
        cpfCnpj size: 11..14, nullable: false
        deleted min: 0, max: 1, nullable: false
        email email: true, size: 5..255, nullable: false
        phone size: 1..255, nullable: false
        name size: 1..255, nullable: false
        postalCode size: 1..255, nullable: false
        province size: 1..255, nullable: false
        state size: 1..255, nullable: false
        lastUpdate nullable: true
        birthDate nullable: true

    }
    


    
}