package criaapp

import com.asinha.domain.Payment
import com.asinha.domain.PaymentService
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gorm.transactions.Transactional
import grails.plugin.asyncmail.AsynchronousMailService

@Transactional
class TaskDueDateJob {

    AsynchronousMailService asyncMailService
    grails.gsp.PageRenderer groovyPageRenderer

    static triggers = {
        cron name: 'dueDate', cronExpression: "0 1 0 1/1 * ? *"
    }
  
    static concurrent = false

    def paymentService

    def execute(){
        Date yesterday = CustomDateUtils.getYesterday()
        List<Payment> paymentList = paymentService.listPaymentByStatusAndDate(PaymentStatus.PENDING, yesterday)
        for(Payment payment : paymentList) {
            payment.status = PaymentStatus.OVERDUE
            payment.save(flush: true, failOnError:true)
            asyncMailService.sendMail {
                to payment.customer.email
                subject "Notificação de cobrança vencida"
                html groovyPageRenderer.render(template: "/email/overduePaymentCustomer", model: [payment: payment])
            }
            asyncMailService.sendMail {
                to payment.payer.email
                subject "Notificação de cobrança vencida"
                html groovyPageRenderer.render(template: "/email/overduePaymentPayer", model: [payment: payment])
            }
        }
    }
}
