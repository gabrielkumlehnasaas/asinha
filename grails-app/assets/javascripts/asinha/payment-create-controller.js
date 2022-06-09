function PaymentCreateController() {
    
    this.reference = $("#payment-create-container");
    var valueInputReference = this.reference.find("#value").get(0);
    var errorMessageReference = this.reference.find("#error").get(0);
    var _this = this;
    
    this.init = function() {
        bindForm();
        bindValue();
    };

    var bindValue = function() {
        valueInputReference.addEventListener("focusout", function() {
            var value = parseFloat(valueInputReference.value.replaceAll(",", ""));
            if (value < 5) {
                errorMessageReference.innerHTML = "O valor mínimo de cobrança é de R$5,00";
                return
            };
            
            errorMessageReference.innerHTML = "";
        });
    };

    var bindForm = function() {
        _this.reference.find("#create-form").on("submit", function(event) {
            event.preventDefault();
            submitForm();
        });
    };

    var submitForm = function() {
        let infosPayment = {};
        let data = new FormData(document.querySelector("#create-form"));
        
        data.forEach(function (value,key) {
            infosPayment[key] = value;
        });
        var url = document.querySelector("#create-form").getAttribute("action");

        $.post(url, infosPayment, function(response) {
            if (!response.success) {
                errorMessages = "";
                response.messages.forEach(function (value) {
                    errorMessages += value + "\n";
                });
                alert("Erro ao Criar Cobrança:\n" + errorMessages);
                return
            }

            window.location.href = document.querySelector("#create-form").getAttribute("data-redirect");
        });
    }
};

var paymentCreateController;

$(document).ready(function () {
    paymentCreateController = new PaymentCreateController();
    paymentCreateController.init();   
});
