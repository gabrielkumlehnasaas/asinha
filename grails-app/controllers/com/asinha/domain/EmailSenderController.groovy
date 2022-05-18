package criaapp

class EmailSenderController {

    def index() {}
    
    def send() {
        try {
            sendMail {
                to params.emailSendEmail
                subject params.subjectSendEmail
                text params.messageSendEmail
            }
                flash.message = "E-mail enviado em "+new Date()
                flash.type = "success"
        } catch (Exception e) {
            flash.message = "Erro ao enviar E-mail"
            flash.type = "error"
        } finally {
            redirect action:"index"
        }
    }
}
