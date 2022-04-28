$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();
        let infosCustomer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            if (key != "cpfCnpjRadio") infosCustomer[key] = value;
        });
        var url = document.querySelector("form").getAttribute("action");
        $.post(url, infosCustomer, function(response) {
            console.log(response);
            window.location.href = document.querySelector("form").getAttribute("data-redirect")
        });

    });

});