package com.asinha.domain
import com.asinha.domain.Payer
import com.asinha.domain.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PayerController {

    def payerService

    def update() {
        try {
            Payer payer = payerService.update(params)
            if (payer){
                redirect([action: "show", id: payer.id])
            }
        } catch(Exception exception) {}
    }

    def show(){
        Integer id = params.int("id")
        return [payer: payerService.getPayer(id)]
    }

    def index() {
    }

    def list() {
        Integer customerId = params.int("id")
        def payerCriteria = Payer.createCriteria()
        def payerList = payerCriteria.list(max: 10, offset: getCurrentPage()) {
            like("customer", Customer.get(customerId))
        }
        [payerList: payerList, totalCount: Payer.count()]
    }
    
    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }

    def create() {
        Integer id = params.int("id")
        return [customerId: id]
    }

    def save() {
        try {Payer payer = payerService.save(params)
            if(payer) {
                render([success: true])
            }
        } catch(Exception exception) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }
}