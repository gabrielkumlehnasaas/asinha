class Cliente {
    
    constructor(nome, cpf_cnpj, endereco, numero, cidade, estado, bairro, cep, email, telefone) {
        this._nome = nome;
        this._cpf_cnpj = cpf_cnpj;
        this._endereco = endereco;
        this._numero = numero;
        this._cidade = cidade;
        this._estado = estado;
        this._cep = cep;
        this._email = email;
        this._bairro = bairro;
        this._telefone = telefone;
        this._data_criacao = DateHelper.dataParaTexto(new Date())
    }
}