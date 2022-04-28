var cpfCnpjLabelReference = $("#cpfCnpjLabel").get(0);
var addressInputReference = $("#address").get(0);
var addressNumberInputReference = $("#addressNumber").get(0);
var emailInputReference = $("#email").get(0);
var provinceInputReference = $("#province").get(0);
var cityInputReference = $("#city").get(0);
var stateInputReference = $("#state").get(0);
var cpfCnpjInputReference = $("#cpfCnpj").get(0);
var phoneInputReference = $("#phone").get(0);
var cepInputReference = $("#cep").get(0);
var errorMessageReference = $("#error").get(0)

new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
new Inputmask({mask: ["(99) 9999-9999", "(99) 99999-9999"], showMaskOnHover: false, keepStatic: true}).mask(phoneInputReference);
new Inputmask({mask: "99999-999", showMaskOnHover: false, keepStatic: true}).mask(cepInputReference);

var cpfRadioReference = $("#cpfRadio").get(0);
var cnpjRadioReference = $("#cnpjRadio").get(0);

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
            }
        })
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