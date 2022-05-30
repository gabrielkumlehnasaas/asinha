function PaymentConfirmController() {
    
    this.reference = $("#payer-show-container");
    var confirmButtonReference = this.reference.find("#confirmbtn");
    var inputStatusReference = this.reference.find("#status").get(0);
    this_ = this;
    
    this.init = function() {
        initConfirmButtonHidder();
        bindConfirmButton();
    };

    var initConfirmButtonHidder = function() {
        if ( inputStatusReference.value == "Pago" ) {
            confirmButtonReference.attr("hidden", true);
        }
    }

    var bindConfirmButton = function() {
        confirmButtonReference.on("click", function() {
            if (confirm("Essa cobrança foi realmente recebida?")) {
                submitConfirm();
            };
        });
    };

    var submitConfirm = function() {
        let infosPayment = {};
        let data = new FormData(document.querySelector("#create-form"));
        
        data.forEach(function (value,key) {
            infosPayment[key] = value;
        });
        var url = document.querySelector("#create-form").getAttribute("action");
        $.post(url, infosPayment, function(response) {
            if (!response.success) {
                alert("Erro ao Confirmar Pagamento")
                return
            }
            window.location.href = document.querySelector("#create-form").getAttribute("data-redirect");
        });
    };
                                                                                                                                                                     
};

var paymentConfirmController;

$(document).ready(function () {
    paymentConfirmController = new PaymentConfirmController();
    paymentConfirmController.init();   
});
