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
        paymentService.updateOverduePayments()
    }
}
