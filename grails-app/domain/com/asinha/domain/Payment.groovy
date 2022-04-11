package com.asinha.domain

class  Payment {

    long id
    Customer customer
    Payer payer
    float value
    String method
    String status
    String desciption
    Date dueDate
    Date paymentDate
    Date lastUpdate
    int deleted


    static constraints = {
        id unique: true, nullable: false
        value min: 5, nullable: false
        method inList: ["BOLETO", "CARTAO", "PIX"]
        status inList: ["CONFIRMED", "OVERDUE", "PENDING", "RECEIVED", "REFUNDED"]
        deleted min: 0, max: 1, nullable: false

    }
}
