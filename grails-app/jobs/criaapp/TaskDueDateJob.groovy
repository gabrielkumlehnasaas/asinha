package criaapp

import com.asinha.domain.Payment
import com.asinha.enums.PaymentStatus

import grails.gorm.transactions.Transactional

@Transactional
class TaskDueDateJob {
  
  static triggers = {
    cron name: 'dueDate', cronExpression: "0 0/1 * 1/1 * ? *"
  }
  
  static concurrent = false

  def execute(){
    Date today = new Date()
    List<Payment> paymentList = Payment.list()
    for(Payment payment : paymentList) {
      if(today.after(payment.dueDate)) {
        payment.status = PaymentStatus.OVERDUE
        payment.lastUpdate = today
        payment.save(flush: true, failOnError:true)
        print "Job Executando..."
      }
    }
  }
    public static Date getYesterday() {
    Calendar yesterday = getInstanceOfCalendar(new Date())
    yesterday.add(Calendar.DATE, -1)
    return yesterday.getTime().clearTime()
  }    
}

