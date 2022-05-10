function PaymentCreate() {
    
    this.reference = $("#payment-create-container");
    var valueInputReference = this.reference.find("#value").get(0);
    var errorMessageReference = this.reference.find("#error").get(0);
    var _this = this;

    var initInputMasks = function() {
        $("#value").maskMoney({prefix:'R$ ', allowNegative: false, thousands:',', decimal:'.', affixesStay: false});
    };

    var bindValue = function() {
        valueInputReference.addEventListener("focusout", function() {
            var value = parseFloat(valueInputReference.value);
            if (value < 5) {
                console.log("erro")
                errorMessageReference.innerHTML = "O valor mínimo de cobrança é de R$5,00";
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
        let infosPayment = {};
        let data = new FormData(document.querySelector("form"));
        
        data.forEach(function (value,key) {
            infosPayment[key] = value;
        });
      
        var url = document.querySelector("form").getAttribute("action");

        $.post(url, infosPayment, function(response) {
            console.log(response);
            // window.location.href = document.querySelector("form").getAttribute("data-redirect"); para quando existir view list
        });
    }

    this.init = function() {
        initInputMasks();
        bindForm();
        bindValue();
    };
};

var paymentCreate;

$(document).ready(function () {
    paymentCreate = new PaymentCreate();
    paymentCreate.init();   
});