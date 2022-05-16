function ValueMask() {

    var valueInputReference = $("#value").get(0);

    this.init = function() {
        $("#value").maskMoney({prefix:'R$ ', allowNegative: false, thousands:',', decimal:'.', affixesStay: false});
    };
}

var valueMasks;

$(document).ready(function () {
    valueMasks = new ValueMasks();
    valueMasks.init();   
});
