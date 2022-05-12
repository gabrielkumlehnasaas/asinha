function PayerShow() {
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
    var payerIdInputReference = this.reference.find("#payerId").get(0);
    var editButton = this.reference.find("#editbtn");
    var updateButton = this.reference.find("#updatebtn");
    var _this = this
    
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
            console.log(response);
            window.location.href = `/payer/show/${ infosPayer.id }`;
        });
    };
    var bindEditPayer = function() {
        editButton.on("click", function(e) {
            e.preventDefault();
            editButton.attr("hidden", true);
            updateButton.attr("hidden", false);
            payerIdInputReference.disabled = false;
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
        })
    }
    var disableInputs = function () {
        payerIdInputReference.disabled = true;
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
    this.init = function() {
        bindForm();
        bindEditPayer();
    };
};
var payerShow;
$(document).ready(function () {
    payerShow = new PayerShow();
    payerShow.init();
});