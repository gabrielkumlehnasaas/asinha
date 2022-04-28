$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            if (key != "cpfCnpjRadio") infosCustomer[key] = value;
        });
        $.post(document.querySelector("form").getAttribute("action"), infosCustomer, function(response) {
            console.log(response);
            window.location.href = "/customer/index"
        });

    });

});