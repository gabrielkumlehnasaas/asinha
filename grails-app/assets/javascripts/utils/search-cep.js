function SearchCep() {
    var _this = this;

    this.getPostalCode = function(cep, callbackFunction) {
        if (cepCleaner(cep).length == 8) {
            const endpoint = `http://viacep.com.br/ws/${cep}/json/`;
            let params = { method: "get", body: null };
            fetch(endpoint, params)
            .then(result => result.json())
            .then(function (dados) { 
                callbackFunction(dados)
            });
        };
    }

    var cepCleaner = function(cep) {
        return cep.replace(/\D/g, '');    
    };
}