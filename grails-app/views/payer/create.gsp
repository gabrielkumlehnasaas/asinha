<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Cadastro de pagadores</title>
    </head>
    <body>
        <div class="container-fluid" id="payer-create-container">
            <p id="error"></p>
            <div class="formulario" id="createFormCustomer">
            <form class="form row" id="create-form" data-redirect="${ g.createLink([controller:'payer', action:'list', params:[customerId: customerId]]) }" action="${ g.createLink([controller:'payer', action:'save']) }">
                <div class="row">
                    <div class="col-md-3 p-3 bg-light shadow-lg">
                        <div class="form-check">
                            <input class="form-check-input shadow-lg" type="radio" name="cpfCnpjRadio" id="cpfRadio" checked>
                            <label class="form-check-label shadow-lg" for="cpfCnpjRadio">Pessoa Física</label>
                        </div>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <div class="form-check">
                            <input class="form-check-input shadow-lg" type="radio" name="cpfCnpjRadio" id="cnpjRadio">
                            <label class="form-check-label shadow-lg" for="cpfCnpjRadio">Pessoa Jurídica</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="Name">Nome</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <label for="cpfCnpj" id="cpfCnpjLabel">CPF</label>
                        <input type="text" class="form-control" id="cpfCnpj" name="cpfCnpj" required>
                    </div>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="email">E-mail</label>
                        <small id="textEmail"></small>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <label for="phone">Telefone</label>
                        <input type="text" class="form-control" id="phone" name="phone" required>
                    </div>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="postalCode">CEP</label>
                        <input type="text" class="form-control" id="cep" name="postalCode" required>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <label for="addess">Endereço</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="addressNumber">Número</label>
                        <input type="text" class="form-control" id="addressNumber" name="addressNumber" required>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <label for="province">Bairro</label>
                        <input type="text" class="form-control" id="province" name="province" required>
                    </div>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light ">
                        <g:render template="/utils/selectStates"/>
                    </div>
                    <div class="col-md-2 p-3 bg-light">
                        <label for="city">Cidade</label>
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-padding-y" id="create" name="create">Criar pagador</button>
                <div>
                    <a href="${ g.createLink([controller:'customer', action:'show']) }"><button type="button" id="backPayer" class="btn btn-primary btn-padding-y">Voltar</button></a>
                </div>
            </form>
            </div>
        </div> 
        <asset:javascript src="payer-create-import.js"/>
        <asset:image src="logoasinhaclean.png" id="logoasinha"/>
        <asset:image src="logouser2.png" id="logouser"/>
    </body>
</html>
