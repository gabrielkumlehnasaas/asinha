package criaapp

import com.asinha.domain.EmailService
import com.asinha.domain.Payment
import com.asinha.domain.PaymentService
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gorm.transactions.Transactional

@Transactional
class TaskDueDateJob {


    static triggers = {
        cron name: 'dueDate', cronExpression: "0 1 0 1/1 * ? *"
    }
  
    static concurrent = false

    grails.gsp.PageRenderer groovyPageRenderer
    def emailService
    def paymentService

    def execute(){
        Date yesterday = CustomDateUtils.getYesterday()
        List<Payment> paymentList = paymentService.listPaymentByStatusAndDate(PaymentStatus.PENDING, yesterday)
        for(Payment payment : paymentList) {
            payment.status = PaymentStatus.OVERDUE
            payment.save(flush: true, failOnError:true)
            String subject = "Notificação de cobrança vencida"
            emailService.sendEmail(payment.customer.email, subject, groovyPageRenderer.render(template: "/email/overduePaymentCustomer", model: [payment: payment]))
            emailService.sendEmail(payment.payer.email, subject, groovyPageRenderer.render(template: "/email/overduePaymentPayer", model: [payment: payment]))
        }
    }
}
