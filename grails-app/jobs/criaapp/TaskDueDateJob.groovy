package criaapp

class TaskDueDateJob {
  
  static triggers = {
    cron name: 'dueDate', cronExpression: "0 0/1 * 1/1 * ?"
  }
  
  static concurrent = false
    def execute(){
    print "Job run!"
  }
}
