$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            infosCustomer[key] = value;
        });
        delete infosCustomer.cpfCnpjRadio;
        delete infosCustomer.create;

        $.post("/customer/save", infosCustomer, function(response) {
            console.log(response)
        });

    });
});