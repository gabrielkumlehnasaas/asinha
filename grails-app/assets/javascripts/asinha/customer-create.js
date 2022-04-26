// Labels
var cpfCnpjLabelReference = $("#cpfCnpjLabel")[0];

// Inputs
var addressInputReference = $("#address")[0];
var addressNumberInputReference = $("#addressNumber")[0];
var emailInputReference = $("#email")[0];
var provinceInputReference = $("#province")[0];
var cityInputReference = $("#city")[0];
var stateInputReference = $("#state")[0];
var cpfCnpjInputReference = $("#cpfCnpj")[0];
var phoneInputReference = $("#phone")[0];
var cepInputReference = $("#cep")[0];

// Error message
var errorMessageReference = $("#error")[0]

// Inputmasks
new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
new Inputmask({mask: ["(99) 9999-9999", "(99) 99999-9999"], showMaskOnHover: false, keepStatic: true}).mask(phoneInputReference);
new Inputmask({mask: "99999-999", showMaskOnHover: false, keepStatic: true}).mask(cepInputReference);

// Radio Buttons
var cpfRadioReference = $("#cpfRadio")[0];
var cnpjRadioReference = $("#cnpjRadio")[0];

cpfRadioReference.click( function() {
    cpfCnpjLabelReference.html("CPF");
    new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
})

cnpjRadioReference.click( function() {
    cpfCnpjLabelReference.html("CNPJ");
    new Inputmask({mask: "99.999.999/9999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
})

// Cep Handler
var preeencherFormulario = (endereco) => {
    addressInputReference.value = endereco.logradouro;
    provinceInputReference.value = endereco.bairro;
    cityInputReference.value = endereco.localidade;
    stateInputReference.value = endereco.uf;
    addressNumberInputReference.focus();
}

var cepCleaner = function(cep) {
    var cleanCep = cep.replace(/\D/g, '')
    return cleanCep    
}

var limpaFormulario = () => {
    addressInputReference.value = "";
    provinceInputReference.value = "";
    cityInputReference.value = "";
    stateInputReference.value = "";
}
    
var pesquisarCep = async() => {
    const cep = cepInputReference.value;
    if (cepCleaner(cep).length == 8) {
        const endpoint = `http://viacep.com.br/ws/${cep}/json/`;
        let params = { method: "get", body: null };
        fetch(endpoint, params)
        .then(result => result.json())
        .then(function (dados) { 
            let error = ("erro" in dados);
            if (!error) {
                document.getElementById("error").innerHTML = "";
                preeencherFormulario(dados);
            }else{
                limpaFormulario();
                document.getElementById("error").innerHTML = "CEP inválido";
            }})
        }
    }

cepInputReference.addEventListener("input", pesquisarCep)

// Email Validation
emailInputReference.addEventListener("focusout", function() {
    var email = document.getElementById("email").value;
    if (email.indexOf(".com") == -1) {
        document.getElementById("error").innerHTML = "E-mail Inválido";
    } else {
        document.getElementById("error").innerHTML = "";
    }
})


$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            infosCustomer[key] = value;
        });
        delete infosCustomer.cpfCnpjRadio;
        $.post("/customer/save", infosCustomer, function(response) {
            console.log(response);
            window.location.href = "/customer/index"
        });

    });

});