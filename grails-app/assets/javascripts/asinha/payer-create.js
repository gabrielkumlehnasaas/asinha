function PayerCreate() {
    
    this.reference = $("#payer-create-container");
    var cpfCnpjLabelReference = this.reference.find("#cpfCnpjLabel").get(0);
    var addressInputReference = this.reference.find("#address").get(0);
    var addressNumberInputReference = this.reference.find("#addressNumber").get(0);
    var emailInputReference = this.reference.find("#email").get(0);
    var provinceInputReference = this.reference.find("#province").get(0);
    var cityInputReference = this.reference.find("#city").get(0);
    var stateInputReference = this.reference.find("#state").get(0);
    var cpfCnpjInputReference = this.reference.find("#cpfCnpj").get(0);
    var phoneInputReference = this.reference.find("#phone").get(0);
    var cepInputReference = this.reference.find("#cep").get(0);
    var errorMessageReference = this.reference.find("#error").get(0);
    var searchCep;
    var _this = this;

    var initInputMasks = function() {
        new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        new Inputmask({mask: ["(99) 9999-9999", "(99) 9 9999-9999"], showMaskOnHover: false, keepStatic: true}).mask(phoneInputReference);
        new Inputmask({mask: "99999-999", showMaskOnHover: false, keepStatic: true}).mask(cepInputReference);
    };

    var bindRadioButton = function() {
        _this.reference.find("#cpfRadio").on("click", function() {
            cpfCnpjLabelReference.innerHTML = "CPF";
            Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        });

        _this.reference.find("#cnpjRadio").on("click", function() {
            cpfCnpjLabelReference.innerHTML = "CNPJ";
            new Inputmask({mask: "99.999.999/9999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        });
    };

    var preeencherFormulario = (endereco) => {
        addressInputReference.value = endereco.logradouro;
        provinceInputReference.value = endereco.bairro;
        cityInputReference.value = endereco.localidade;
        stateInputReference.value = endereco.uf;
        addressNumberInputReference.focus();
    };

    var limpaFormulario = () => {
        addressInputReference.value = "";
        provinceInputReference.value = "";
        cityInputReference.value = "";
        stateInputReference.value = "";
    };
    
    var pesquisarCep = function(data) {
        let error = ("erro" in data);
        if (!error) {
            errorMessageReference.innerHTML = "";
            preeencherFormulario(data);
        } else {
            limpaFormulario();
            errorMessageReference.innerHTML = "CEP inválido";
        };
    };

    var bindCep = function() {
        cepInputReference.addEventListener("input", function() {
            searchCep.getPostalCode(this.value, pesquisarCep)
        });
    };

    var bindEmail = function() {
        emailInputReference.addEventListener("focusout", function() {
            var email = emailInputReference.value;
            if (email.indexOf(".com") == -1) {
                errorMessageReferenceinnerHTML = "E-mail Inválido";
            } else {
                errorMessageReference.innerHTML = "";
            };
        });
    };

    var bindForm = function() {
        _this.reference.find("form").on("submit", function(event) {
            event.preventDefault();
            submitForm();
        });
    };

    var submitForm = function() {
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        
        data.forEach(function (value,key) {
            if (key != "cpfCnpjRadio") infosCustomer[key] = value;
        });
        
        var url = document.querySelector("form").getAttribute("action");

        $.post(url, infosCustomer, function(response) {
            console.log(response);
            window.location.href = document.querySelector("form").getAttribute("data-redirect");
        });
    }

    this.init = function() {
        initInputMasks();
        bindForm();
        bindRadioButton();
        bindCep();
        bindEmail();
        searchCep = new SearchCep();
    };
};

var customerCreate;

$(document).ready(function () {
    customerCreate = new CustomerCreate();
    customerCreate.init();   
});