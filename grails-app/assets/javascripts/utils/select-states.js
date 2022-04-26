function SelectStates() {
    var _this = this;
    const selectStates = document.querySelector("#state");
    
    this.populateSelectStates = function() {
        fetch("https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome")
        .then(response => response.json())
        .then(states => {
            states.map(state => {
                let option = document.createElement("option");
                option.setAttribute("value", state.sigla);
                option.textContent = state.sigla;
                console.log(selectStates);
                selectStates.appendChild(option);
            });
        });
    }

    this.setValue = function(value) {
        selectStates.value = value;
    }
}

var selectStates;

$(document).ready(function() {
    selectStates = new SelectStates();
    selectStates.populateSelectStates();
}) 