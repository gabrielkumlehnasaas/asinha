package criaapp

class EmailSenderController {

    def index() {}
    
    def send() {
    sendMail {
        to params.emailImputSendEmail
        subject params.subjectImputSendEmail
        text params.messageImputSendEmail
    }

        flash.message = "E-mail enviado em "+new Date()
        redirect action:"index"
    }
}
