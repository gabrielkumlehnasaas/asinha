$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            infosCustomer[key] = value;
        });
        delete infosCustomer.cpfCnpjRadio;
        $.post(document.querySelector("form").getAttribute("action"), infosCustomer, function(response) {
            console.log(response);
            window.location.href = "/customer/index"
        });

    });

});