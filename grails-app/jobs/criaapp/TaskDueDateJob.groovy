package criaapp

import com.asinha.domain.Payment
import com.asinha.enums.PaymentStatus
import com.asinha.domain.PaymentService

class TaskDueDateJob {

  def paymentService
  
  static triggers = {
    cron name: 'dueDate', cronExpression: "0 0/1 * 1/1 * ?"
  }
  
  static concurrent = false

  def execute(){
    Date today = new Date()
    println(today)
    List<payment> paymentList = Payment.list()
    paymentList.forEach(payment -> {
      println(payment.dueDate)
      if(today.after(payment.dueDate)) {
        payment.status = PaymentStatus.OVERDUE
        payment.lastUpdate = today
        payment.save(flush: true, failOnError:true)
      }
    })
  } 
  
}
