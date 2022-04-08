function CadastroController() {
    var _this = this;
    
    this.init = function() {
        let $ = document.querySelector.bind(document);
        this._inputNome = $('#nome');
        this._inputCpfCnpj = $('#cpf-cnpj');
        this._inputEmail = $('#email');
        this._inputCep = $('#cep');
        this._inputBairro = $('#bairro');
        this._inputTelefone = $('#telefone');
        this._inputEndereco = $('#endereco');
        this._inputNumero = $('#numero');
        this._inputCidade = $('#cidade');
        this._inputEstado = $('#estado');
        this._inputSenha = $('#senha');
        this._inputConfSenha = $('#confirmacao-senha');
        this._checkbox = $('#termos');
        this._form = $('#form-cadastro');
        this._error = $("#error");

        bindCepInput();
        bindSubmit();
    };

    var bindCepInput = function() {
        _this._inputCep.addEventListener("input", function() {
            if(_this._inputCep.value.length == 8){
                procuraCep(_this._inputCep.value);
            }
        });
    }

    var bindSubmit = function() {
        _this._form.addEventListener("submit", function(event) {
            event.preventDefault();
            cadastra();
        })
    }

    var cadastra = function() {
        if (_this._inputSenha.value == _this._inputConfSenha.value) {
            _this._error.innerHTML = " ";
            criaCliente();
            limpaFormulario();
            alert("Cliente cadastrado com sucesso");
        }else{
            _this._error.innerHTML = "Senhas não são iguais";
        }
    }

    var criaCliente = function() {
        var novoCliente = new Cliente(
            _this._inputNome.value,
            _this._inputCpfCnpj.value,
            _this._inputEndereco.value,
            _this._inputNumero.value,
            _this._inputCidade.value,
            _this._inputEstado.value,
            _this._inputBairro.value,
            _this._inputCep.value,
            _this._inputEmail.value,
            _this._inputTelefone.value,
        );
        console.log(novoCliente);
        return novoCliente;
    }

    var limpaFormulario = function() {
        _this._form.reset();
        _this._checkbox.check = false;
    }

    var limpaEndereco = function() {
        _this._inputEndereco.value = "";
        _this._inputCidade.value = "";
        _this._inputEstado.value = "";
        _this._inputBairro.value = "";
    }

    var preencheEndereco = function(endereco) {
        _this._inputEndereco.value = endereco.logradouro;
        _this._inputCidade.value = endereco.localidade;
        _this._inputEstado.value = endereco.uf;
        _this._inputBairro.value = endereco.bairro;
    }

    var procuraCep = function(cep) {
        let endpoint = "https://viacep.com.br/ws/" + cep + "/json";
        let params = { method: "get", body: null };
        fetch(endpoint, params)
        .then(result => result.json())
        .then(function (dados) { 
            let error = ("erro" in dados);
            if (!error) {
                preencheEndereco(dados);
                _this._error.innerHTML = "";
                _this._inputNumero.focus();
            }else{
                limpaEndereco();
                _this._error.innerHTML = "CEP inválido";
            }
        });
    }
}

var cadastroController;
$(document).ready(function() {
    cadastroController = new CadastroController();
    cadastroController.init();
});