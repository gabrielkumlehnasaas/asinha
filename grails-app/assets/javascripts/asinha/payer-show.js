function PayerShowAndEditController() {
    
    this.reference = $("#payer-show-container");
    var nameInputReference = this.reference.find("#name").get(0);
    var addressInputReference = this.reference.find("#address").get(0);
    var addressNumberInputReference = this.reference.find("#addressNumber").get(0);
    var emailInputReference = this.reference.find("#email").get(0);
    var provinceInputReference = this.reference.find("#province").get(0);
    var cityInputReference = this.reference.find("#city").get(0);
    var stateInputReference = this.reference.find("#state").get(0);
    var cpfCnpjInputReference = this.reference.find("#cpfCnpj").get(0);
    var phoneInputReference = this.reference.find("#phone").get(0);
    var cepInputReference = this.reference.find("#cep").get(0);
    var complementInputReference = this.reference.find("#complement").get(0);
    var idInputReference = this.reference.find("#id").get(0);
    var editButton = this.reference.find("#editbtn");
    var updateButton = this.reference.find("#updatebtn");
    var _this = this
    
    this.init = function() {
        bindForm();
        bindEditPayer();
    };
    
    var bindForm = function() {
        updateButton.on("click", function (e) {
            e.preventDefault();
            submitForm();
        });
    };

    var submitForm = function() {
        let infosPayer = {};
        let data = new FormData(document.querySelector("form"));
        data.forEach(function (value,key) {
            infosPayer[key] = value;
        });
        var url = document.querySelector("form").getAttribute("action");
        disableInputs();
        $.post(url, infosPayer, function(response) {
            if (!response.success) {
                alert("Erro ao Editar Pagador")
                return
            }
            window.location.href = document.querySelector("form").getAttribute("data-redirect");
        });
    };

    var bindEditPayer = function() {
        editButton.on("click", function(e) {
            e.preventDefault();
            editButton.attr("hidden", true);
            updateButton.attr("hidden", false);
            idInputReference.disabled = false;
            nameInputReference.disabled = false;
            addressInputReference.disabled = false;
            addressNumberInputReference.disabled = false;
            emailInputReference.disabled = false;
            provinceInputReference.disabled = false;
            cityInputReference.disabled = false;
            stateInputReference.disabled = false;
            cpfCnpjInputReference.disabled = false;
            phoneInputReference.disabled = false;
            cepInputReference.disabled = false;
            complementInputReference.disabled = false;
        });
    }

    var disableInputs = function () {
        idInputReference.disabled = true;
        nameInputReference.disabled = true;
        addressInputReference.disabled = true;
        addressNumberInputReference.disabled = true;
        emailInputReference.disabled = true;
        provinceInputReference.disabled = true;
        cityInputReference.disabled = true;
        stateInputReference.disabled = true;
        cpfCnpjInputReference.disabled = true;
        phoneInputReference.disabled = true;
        cepInputReference.disabled = true;
        complementInputReference.disabled = true;
    }
};

var payerShowAndEditController;

$(document).ready(function () {
    payerShowAndEditController = new PayerShowAndEditController();
    payerShowAndEditController.init();
});
