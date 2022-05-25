package com.asinha.domain

import grails.plugin.asyncmail.AsynchronousMailService

class EmailService {

    def asynchronousMailService

    def sendEmail(String email, String subject, String html) {
        asynchronousMailService.sendMail {
            to email
            subject subject
            html html
        }
    }
}