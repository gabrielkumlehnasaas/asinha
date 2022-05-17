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
        let data = new FormData(document.querySelector("form"));
        
        data.forEach(function (value,key) {
            infosPayment[key] = value;
        });
        var url = document.querySelector("form").getAttribute("action");
        $.post(url, infosPayment, function(response) {
            window.location.href = document.querySelector("form").getAttribute("data-redirect");
        });
    };
                                                                                                                                                                     
};

var paymentConfirmController;

$(document).ready(function () {
    paymentConfirmController = new PaymentConfirmController();
    paymentConfirmController.init();   
});