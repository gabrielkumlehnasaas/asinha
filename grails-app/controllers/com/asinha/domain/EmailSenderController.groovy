package com.asinha.domain

import com.asinha.utils.CustomDateUtils

import java.sql.Timestamp

class EmailSenderController {

    def emailSenderService

    def index() {}

    def send() {
        try {
            // sendMail {
            //     to params.email
            //     subject params.subject
            //     text params.message
            // }
            
            emailSenderService.sendEmail(params.email, params.subject, params.message)
            Date now = new Date()
            Timestamp ts = new Timestamp(now.getTime())
            flash.message = "E-mail enviado em " + CustomDateUtils.formatTimestamp(ts)
            flash.type = "success"
        } catch (Exception e) {
            flash.message = "Erro ao enviar E-mail"
            flash.type = "error"
        } finally {
            redirect action:"index"
        }
    }
}
