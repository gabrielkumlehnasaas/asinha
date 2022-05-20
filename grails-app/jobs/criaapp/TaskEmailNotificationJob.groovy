package criaapp

import com.asinha.domain.EmailSenderService
import com.asinha.domain.Payment
import com.asinha.domain.PaymentService
import com.asinha.enums.PaymentStatus

class TaskEmailNotificationJob {
    static triggers = {
        cron name: 'dueDate', cronExpression: "0/30 0 0 ? * * *"
    }
    
    def paymentService
    def groovyPageRenderer
    def emailSenderService

    String customerTemplate = '/utils/newPaymentCustomer'
    String payerTemplate = '/utils/newPaymentPayer'

    def execute() {
        List<Payment> paymentList = paymentService.listLastNewPaymentsByMin(PaymentStatus.PENDING, 1)
        String subject = "Notificação de nova cobrança"
        println(subject)
        for(Payment payment : paymentList) {
            emailSenderService.emailSender(payment.customer.email, subject, customerTemplate, payment)
            emailSenderService.emailSender(payment.payer.email, subject, payerTemplate, payment)
        }
    }
}
