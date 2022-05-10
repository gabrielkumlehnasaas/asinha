package com.asinha.domain

import com.asinha.base.BaseEntity
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus

class Payment extends BaseEntity {

    BigDecimal value
    
    String description
    
    PaymentMethod method
    
    PaymentStatus status
    
    Date dueDate
    
    Date paymentDate
    
    Payer payer
    
    Customer customer

    static constraints = {
        value min: 5.00, nullable: false
        method nullable: false
        status nullable: false
        payer nullable: false
        customer nullable: false
        dueDate nullable: false
        paymentDate nullable: true
    }
}