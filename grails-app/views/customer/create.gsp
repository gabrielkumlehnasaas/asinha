
<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main" /> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Cadastro de clientes</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <div class="container-fluid">
            <p id="error"></p>
            <form class="form row" id="create-form" data-redirect="/customer/index" action="${ g.createLink([controller:'customer', action:'save']) }">
                <div class="col-md-6 p-3 bg-light">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="cpfCnpjRadio" id="cpfRadio" checked>
                        <label class="form-check-label" for="cpfCnpjRadio">Pessoa Física</label>
                    </div>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="cpfCnpjRadio" id="cnpjRadio">
                        <label class="form-check-label" for="cpfCnpjRadio">Pessoa Jurídica</label>
                    </div>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="Name">Nome</label>
                    <input type="text" class="form-control border border-1 border-dark" name="name" id="name" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="cpfCnpj" id="cpfCnpjLabel">CPF</label>
                    <input type="text" class="form-control border border-1 border-dark" name="cpfCnpj" id="cpfCnpj" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="email">E-mail</label>
                    <small id="textEmail"></small>
                    <input type="email" class="form-control border border-1 border-dark" id="email" placeholder="email@address.com" name="email" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="phone">Telefone</label>
                    <input type="text" class="form-control border border-1 border-dark" id="phone" name="phone" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="postalCode">CEP</label>
                    <input type="text" class="form-control border border-1 border-dark" id="cep" name="postalCode" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="addess">Endereço</label>
                    <input type="text" class="form-control border border-1 border-dark" id="address" placeholder="" name="address" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="addressNumber">Número</label>
                    <input type="text" class="form-control border border-1 border-dark" id="addressNumber" placeholder="" name="addressNumber" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="province">Bairro</label>
                    <input type="text" class="form-control border border-1 border-dark" id="province" placeholder="" name="province" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="complement">Complemento</label>
                    <input type="text" class="form-control border border-1 border-dark" id="complement" placeholder="" name="complement">
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="city">Cidade</label>
                    <input type="text" class="form-control border border-1 border-dark" id="city" placeholder="" name="city" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <g:render template="/utils/selectStates"/>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <input type="checkbox" id="termos" required>
                        <label for="termos">Li e concordo com os 
                        <a href="https://ajuda.asaas.com/pt-BR/articles/102021-termos-e-condicoes-de-uso">Termos de Uso do Asaas</a>.</label>
                </div>
                <input class="btn btn-primary btn-padding-y 10 save " type="submit" name="create" id="create">
            </form>
        </div> 
        <asset:javascript src="asinha/masks.js"/>
        <asset:javascript src="asinha/customer-create.js"/>
    </body>
</html>