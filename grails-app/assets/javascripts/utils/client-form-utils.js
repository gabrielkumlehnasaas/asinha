function ClientFormUtils() {

    var phoneInputReference = $("#phone").get(0);
    var cepInputReference = $("#cep").get(0);
    var cpfCnpjInputReference = $("#cpfCnpj").get(0);
    var cpfCnpjLabelReference = $("#cpfCnpjLabel").get(0);

    this.init = function() {
        initInputMasks();
        bindRadioButton();
    }
        
    var initInputMasks = function() {
        new Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        new Inputmask({mask: ["(99) 9999-9999", "(99) 9 9999-9999"], showMaskOnHover: false, keepStatic: true}).mask(phoneInputReference);
        new Inputmask({mask: "99999-999", showMaskOnHover: false, keepStatic: true}).mask(cepInputReference);
    };

    var bindRadioButton = function() {
        $("#cpfRadio").on("click", function() {
            cpfCnpjLabelReference.innerHTML = "CPF";
            Inputmask({mask: "999.999.999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        });

        $("#cnpjRadio").on("click", function() {
            cpfCnpjLabelReference.innerHTML = "CNPJ";
            new Inputmask({mask: "99.999.999/9999-99", showMaskOnHover: false, keepStatic: true}).mask(cpfCnpjInputReference);
        });
    };
}

var clientFormUtils;

$(document).ready(function () {
    clientFormUtils= new ClientFormUtils();
    clientFormUtils.init();   
});