package criaapp

import com.asinha.domain.EmailSenderService
import com.asinha.domain.Payment
import com.asinha.domain.PaymentService
import com.asinha.enums.PaymentStatus

class TaskEmailNotificationJob {
    
    static triggers = {
        cron name: 'EmailNotification', cronExpression: "0/20 * * ? * * *"
    }
    
    def paymentService
    def emailSenderController

    String customerTemplate = '/email/newPaymentCustomer'
    String payerTemplate = '/email/newPaymentPayer'

    def execute() {
        // List<Payment> paymentList = paymentService.listLastNewPaymentsByMin(PaymentStatus.PENDING, 1)
        String subject = "Notificação de nova cobrança"
        println(subject)
        EmailSenderService.sendEmail("gskumlehn@gmail.com", subject, "/email/test", [name: "name"])
        // for(Payment payment : paymentList) {

        //     emailSenderService.emailSender(payment.customer.email, subject, customerTemplate, payment)
        //     emailSenderService.emailSender(payment.payer.email, subject, payerTemplate, payment)
        // }
    }
}
