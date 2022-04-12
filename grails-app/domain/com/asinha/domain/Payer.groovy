package com.asinha.domain

class  Payer {

    long id
    String address
    String addressNumber
    String city
    String complement
    String cpfCnpj
    Date dateCreated
    int deleted
    String email
    Date lastUpdate
    String phone
    String name
    String postalCode
    String province
    String state
    Customer customer

    static constraints = {
        id unique: true, nullable: false
        address size: 1..255, nullable: false
        addressNumber size: 1..255, nullable: false
        city size: 1..255, nullable: false
        complement size: 1..255
        cpfCnpj unique: true, size: 11..14, nullable: false
        deleted min: 0, max: 1, nullable: false
        email email: true, size: 5..255, nullable: false
        phone size: 1..255, nullable: false
        name size: 1..255, nullable: false
        postalCode size: 1..255, nullable: false
        province size: 1..255, nullable: false
        state size: 1..255, nullable: false

    }
}
