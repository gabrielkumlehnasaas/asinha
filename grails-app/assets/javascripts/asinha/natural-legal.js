var cpfRadioResponse = $("#cpfRadio")
var cnpjRadioResponse = $("#cnpjRadio")
var cpfCnpjLabelResponse = $("#cpfCnpjLabel")

cpfRadioResponse.click( function() {
    cpfCnpjLabelResponse.html("CPF")
})

cnpjRadioResponse.click( function() {
    cpfCnpjLabelResponse.html("CNPJ")
})