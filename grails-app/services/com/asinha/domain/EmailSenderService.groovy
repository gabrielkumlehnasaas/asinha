package com.asinha.domain

class EmailSenderService {

    public static void emailSender(String email, String subject, String template, Map model) {
        sendMail {
            to email
            subject subject
            body(view:template, model: model)
        }

    }
}