package criaapp

import com.asinha.domain.PaymentService

import grails.gorm.transactions.Transactional

@Transactional
class TaskDueDateJob {


    static triggers = {
        cron name: 'dueDate', cronExpression: "0 1 0 1/1 * ? *"
    }
  
    static concurrent = false

    def paymentService

    def execute(){
        paymentService.updateOverduePayments()
    }
}
