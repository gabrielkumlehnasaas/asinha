var preeencherFormulario = (endereco) => {
    document.getElementById("adress").value = endereco.logradouro
    document.getElementById("province").value = endereco.bairro
    document.getElementById("city").value = endereco.localidade
    document.getElementById("estado").value = endereco.uf


}

var pesquisarCep = async() => {
    const cep = document.getElementById("cep").value
    const url = `http://viacep.com.br/ws/${cep}/json/`
    var dados = await fetch(url);
    var endereco = await dados.json();
    preeencherFormulario(endereco)
 }
document.getElementById("cep").addEventListener("focusout", pesquisarCep)
