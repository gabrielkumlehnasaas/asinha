function PayerCreateController() {
    
    this.reference = $("#payer-create-container");
    var addressInputReference = this.reference.find("#address").get(0);
    var addressNumberInputReference = this.reference.find("#addressNumber").get(0);
    var emailInputReference = this.reference.find("#email").get(0);
    var provinceInputReference = this.reference.find("#province").get(0);
    var cityInputReference = this.reference.find("#city").get(0);
    var stateInputReference = this.reference.find("#state").get(0);
    var cepInputReference = this.reference.find("#cep").get(0);
    var searchCep;
    var _this = this;
    
    this.init = function() {
        bindForm();
        bindCep();
        searchCep = new SearchCep();
    };

    var fillForm = (address) => {
        addressInputReference.value = address .logradouro;
        provinceInputReference.value = address .bairro;
        cityInputReference.value = address .localidade;
        stateInputReference.value = address .uf;
        addressNumberInputReference.focus();
    };

    var cleanForm = () => {
        addressInputReference.value = "";
        provinceInputReference.value = "";
        cityInputReference.value = "";
        stateInputReference.value = "";
    };
    
    var validateCep = function(data) {
        let error = ("erro" in data);
        if (error) {
            cleanForm();
            return
        };

        fillForm(data);
    };

    var bindCep = function() {
        cepInputReference.addEventListener("input", function() {
            searchCep.getPostalCode(this.value, validateCep)
        });
    };

    var bindForm = function() {
        _this.reference.find("#create-form").on("submit", function(event) {
            event.preventDefault();
            submitForm();
        });
    };

    var submitForm = function() {
        let infosPayer = {};
        let data = new FormData(document.querySelector("#create-form"));
        
        data.forEach(function (value,key) {
            if (key != "cpfCnpjRadio") infosPayer[key] = value;
        });
        
        var url = document.querySelector("#create-form").getAttribute("action");

        $.post(url, infosPayer, function(response) {
            if (!response.success) {
                errorMessages = ""
                response.messages.forEach(function (value) {
                    errorMessages += value + "\n"
                });
                alert("Erro ao Criar Pagador:\n" + errorMessages)
                return
            }
            
            window.location.href = document.querySelector("#create-form").getAttribute("data-redirect");
        });
    }
};

var payerCreateController;

$(document).ready(function () {
    payerCreateController = new PayerCreateController();
    payerCreateController.init();   
});
