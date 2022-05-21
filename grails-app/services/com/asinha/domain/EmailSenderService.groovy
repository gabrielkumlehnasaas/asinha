package com.asinha.domain

import grails.gsp.PageRenderer

class EmailSenderService {

    public static void sendEmail(String email, String subject, String template, Map model = null) {
        Map args = [template: template, model:model]
        String content = PageRenderer.render(args)
        print(content)
        sendMail {
            to email
            subject subject
            text content
        }
        return
    }
}