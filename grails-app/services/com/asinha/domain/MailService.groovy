package com.asinha.domain

import grails.plugin.asyncmail.AsynchronousMailService

class MailService {

    AsynchronousMailService asyncMailService

    public static void sendEmail(String email, String subject, String html) {
        asyncMailService.sendMail {
            to email
            subject subject
            html html
        }
    }
}