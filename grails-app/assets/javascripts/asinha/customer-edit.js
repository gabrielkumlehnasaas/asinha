var nameInputReference = $("#name")[0];
var addressInputReference = $("#address")[0];
var addressNumberInputReference = $("#addressNumber")[0];
var emailInputReference = $("#email")[0];
var provinceInputReference = $("#province")[0];
var cityInputReference = $("#city")[0];
var stateInputReference = $("#state")[0];
var cpfCnpjInputReference = $("#cpfCnpj")[0];
var phoneInputReference = $("#phone")[0];
var cepInputReference = $("#cep")[0];
var complementInputReference = $("#complement")[0];
var idInputReference = $("#id")[0];

$(document).ready( function() {
    idInputReference.value = idInputReference.dataset.customer;
    nameInputReference.value = nameInputReference.dataset.customer;
    addressInputReference.value = addressInputReference.dataset.customer;
    addressNumberInputReference.value = addressNumberInputReference.dataset.customer;
    emailInputReference.value = emailInputReference.dataset.customer;
    provinceInputReference.value = provinceInputReference.dataset.customer;
    cityInputReference.value = cityInputReference.dataset.customer;
    stateInputReference.value = stateInputReference.dataset.customer;
    cpfCnpjInputReference.value = cpfCnpjInputReference.dataset.customer;
    phoneInputReference.value = phoneInputReference.dataset.customer;
    cepInputReference.value = cepInputReference.dataset.customer;
    complementInputReference.value = complementInputReference.dataset.customer;
})