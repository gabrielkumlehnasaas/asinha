package criaapp

import com.asinha.domain.Payment
import com.asinha.domain.PaymentService
import com.asinha.enums.PaymentStatus
import com.asinha.utils.CustomDateUtils

import grails.gorm.transactions.Transactional

@Transactional
class TaskDueDateJob {
  
    static triggers = {
        cron name: 'dueDate', cronExpression: "0 0/1 * 1/1 * ? *"
    }
  
    static concurrent = false

    def paymentService

    def execute(){
        Date yesterday = CustomDateUtils.getYesterday()
        List<Payment> paymentList = paymentService.listPaymentByStatusAndDate(PaymentStatus.PENDING, yesterday)
        for(Payment payment : paymentList) {
            payment.status = PaymentStatus.OVERDUE
            payment.save(flush: true, failOnError:true)
        }
    }
}
