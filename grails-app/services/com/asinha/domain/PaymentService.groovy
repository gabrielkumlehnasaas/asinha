package com.asinha.domain

import com.asinha.domain.Customer
import com.asinha.domain.Payer
import com.asinha.domain.Payment
import com.asinha.enums.PaymentMethod
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils
import com.asinha.utils.DomainUtils
import com.asinha.utils.ValidationUtils

import grails.gorm.transactions.Transactional
import java.math.BigDecimal

@Transactional
class PaymentService {

    public List<Payment> getPaymentsByCustomer(Long customerId, Integer max, Integer offset) {
        List<Payment> paymentList = Payment.createCriteria().list(max: max, offset: offset) {
            eq("customer", Customer.get(customerId))
        }
        return paymentList
    }

    public Payment save(Map params) {
        Payment payment = new Payment()
        payment = validate(payment, params)
        if (payment.hasErrors()) return payment
        payment.value = new BigDecimal(params.value.replaceAll(",", ""))
        payment.description = params.description
        payment.method = PaymentMethod.valueOf(params.method) 
        payment.status = PaymentStatus.PENDING
        payment.dueDate = CustomDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.save(failOnError: true)
        return payment
    }

    public Payment confirmPayment(paymentId) {
        Payment payment = Payment.get(paymentId)
        payment.status = PaymentStatus.PAID
        payment.paymentDate = new Date()
        payment.save(flush: true, failOnError:true)
        return payment
    }

    public Payment validate(Payment payment, Map params) {
        if (!ValidationUtils.validateValue(params.value)) {
            DomainUtils.addError(payment, 'Cobrança mínima de R$5.00')
        }
        if (!(ValidationUtils.validateNotNull(params.description))) {
            DomainUtils.addError(payment, "Campo Cidade é obrigatório")
        }
        if (!ValidationUtils.validateMethod(params.method)) {
            DomainUtils.addError(payment, "Método de pagamento inválido")
        }
        if (!ValidationUtils.validateDueDate(params.dueDate)) {
            DomainUtils.addError(payment, "Data de vencimento inválida")
        }
        return payment
    }
}
