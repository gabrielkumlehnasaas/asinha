package com.asinha.domain

import com.asinha.base.BaseEntity
import com.asinha.domain.Customer
import com.asinha.domain.Payer
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
        paymentDate nullable: true
    }
}
