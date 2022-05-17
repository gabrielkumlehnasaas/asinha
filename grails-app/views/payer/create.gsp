<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Cadastro de pagadores</title>
    </head>
    <body>
        <div class="container-fluid" id="payer-create-container">
            <p id="error"></p>
            <form class="form row" id="create-form" data-redirect="/payer/index" action="${ g.createLink([controller:'payer', action:'save']) }">
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
                    <input type="text" class="form-control border border-1 border-dark" id="name" name="name" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="cpfCnpj" id="cpfCnpjLabel">CPF</label>
                    <input type="text" class="form-control border border-1 border-dark" id="cpfCnpj" name="cpfCnpj" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="email">E-mail</label>
                    <small id="textEmail"></small>
                    <input type="email" class="form-control border border-1 border-dark" id="email" name="email" required>
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
                    <input type="text" class="form-control border border-1 border-dark" id="address" name="address" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="addressNumber">Número</label>
                    <input type="text" class="form-control border border-1 border-dark" id="addressNumber" name="addressNumber" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="province">Bairro</label>
                    <input type="text" class="form-control border border-1 border-dark" id="province" name="province" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="complement">Complemento</label>
                    <input type="text" class="form-control border border-1 border-dark" id="complement" name="complement">
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="city">Cidade</label>
                    <input type="text" class="form-control border border-1 border-dark" id="city" name="city" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                <g:render template="/utils/selectStates"/>
                </div>
                <input hidden value="${ customerId }" name="customerId" id="customerId">
                <button type="submit" class="btn btn-primary btn-padding-y" id="create" name="create">Criar pagador</button>
            </form>
        </div> 
        <asset:javascript src="payer-create-import.js"/>
    </body>
</html>
