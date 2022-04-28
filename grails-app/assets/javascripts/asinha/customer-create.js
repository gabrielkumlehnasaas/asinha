var cpfCnpjLabelReference = $("#cpfCnpjLabel");
var addressInputReference = $("#address")[0];
var addressNumberInputReference = $("#addressNumber")[0];
var emailInputReference = $("#email")[0];
var provinceInputReference = $("#province")[0];
var cityInputReference = $("#city")[0];
var stateInputReference = $("#state")[0];
var cpfCnpjInputReference = $("#cpfCnpj")[0];
var phoneInputReference = $("#phone")[0];
var cepInputReference = $("#cep")[0];
var errorMessageReference = $("#error")[0]

new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
new Inputmask({mask: ["(99) 9999-9999", "(99) 99999-9999"], showMaskOnHover: false, keepStatic: true}).mask(phoneInputReference);
new Inputmask({mask: "99999-999", showMaskOnHover: false, keepStatic: true}).mask(cepInputReference);

var cpfRadioReference = $("#cpfRadio");
var cnpjRadioReference = $("#cnpjRadio");

cpfRadioReference.click( function() {
    cpfCnpjLabelReference.html("CPF");
    Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
})
cnpjRadioReference.click( function() {
    cpfCnpjLabelReference.html("CNPJ");
    new Inputmask({mask: "99.999.999/9999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
})

var preeencherFormulario = (endereco) => {
    addressInputReference.value = endereco.logradouro;
    provinceInputReference.value = endereco.bairro;
    cityInputReference.value = endereco.localidade;
    stateInputReference.value = endereco.uf;
    addressNumberInputReference.focus();
}

var cepCleaner = (cep) => {
    return cep.replace(/\D/g, '')    
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
                errorMessageReference.innerHTML = "";
                preeencherFormulario(dados);
            }else{
                limpaFormulario();
                errorMessageReference.innerHTML = "CEP inválido";
            }})
        }
    }

cepInputReference.addEventListener("input", pesquisarCep)

emailInputReference.addEventListener("focusout", function() {
    var email = emailInputReference.value;
    if (email.indexOf(".com") == -1) {
        errorMessageReferenceinnerHTML = "E-mail Inválido";
    } else {
        errorMessageReference.innerHTML = "";
    }
})