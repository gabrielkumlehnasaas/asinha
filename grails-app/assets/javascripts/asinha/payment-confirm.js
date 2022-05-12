function PaymentConfirm() {

    this.reference = $("#payer-show-container");
    var confirmButtonReference = this.reference.find("#confirmbtn");
    this_ = this;

    var bindConfirmButton = function() {
        confirmButtonReference.on("click", function() {
            if (confirm("Essa cobrança foi realmente recebida?")) {
                submitConfirm();
            };
        });
    };

    var submitConfirm = function() {
        var url = confirmButtonReference.get(0).getAttribute("data-url");
        $.post(url, function(response) {
            console.log(response);
        });
    };
                                                                                                                                                                     
    this.init = function() {
        bindConfirmButton();
    };
};

var paymentConfirm;

$(document).ready(function () {
    paymentConfirm = new PaymentConfirm();
    paymentConfirm.init();   
});