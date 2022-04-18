<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Cadastro de clientes</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <div class="container-fluid">
            <p id="error"></p>
            <form class="form row" id="create-form" action="${ g.createLink([controller:'customer', action:'save']) }">
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
                    <input type="text" class="form-control border border-1 border-dark" placeholder="" name="name" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="cpfCnpj" id="cpfCnpjLabel">CPF</label>
                    <input type="text" class="form-control border border-1 border-dark" placeholder="" name="cpfCnpj" minlength="11" maxlength="14" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="email">E-mail</label>
                    <input type="email" class="form-control border border-1 border-dark" placeholder="email@address.com" name="email" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="phone">Telefone</label>
                    <input type="text" class="form-control border border-1 border-dark" placeholder="(00) 00000-0000" name="phone" minlength="11" maxlength="11" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="postalCode">CEP</label>
                    <input type="text" class="form-control border border-1 border-dark" placeholder="00.000-000" name="postalCode" minlength="8" maxlength="8" required>
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
                    <input type="text" class="form-control border border-1 border-dark" placeholder="" name="province" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="complement">Complemento</label>
                    <input type="text" class="form-control border border-1 border-dark" placeholder="" name="complement">
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="city">Cidade</label>
                    <input type="text" class="form-control border border-1 border-dark" placeholder="" name="city" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="state">Estado</label>
                    <input list="states" class="form-control border border-1 border-dark" placeholder="" name="state" required>
                    <datalist id="states">
                        <option value="AC"></option> 
                        <option value="AL"></option> 
                        <option value="AM"></option> 
                        <option value="AP"></option> 
                        <option value="BA"></option> 
                        <option value="CE"></option> 
                        <option value="DF"></option> 
                        <option value="ES"></option> 
                        <option value="GO"></option> 
                        <option value="MA"></option> 
                        <option value="MT"></option> 
                        <option value="MS"></option> 
                        <option value="MG"></option> 
                        <option value="PA"></option> 
                        <option value="PB"></option> 
                        <option value="PR"></option> 
                        <option value="PE"></option> 
                        <option value="PI"></option> 
                        <option value="RJ"></option> 
                        <option value="RN"></option> 
                        <option value="RO"></option> 
                        <option value="RS"></option> 
                        <option value="RR"></option> 
                        <option value="SC"></option> 
                        <option value="SE"></option> 
                        <option value="SP"></option> 
                        <option value="TO"></option> 
                    </datalist>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <input type="checkbox" id="termos" required>
                        <label for="termos">Li e concordo com os 
                        <a href="https://ajuda.asaas.com/pt-BR/articles/102021-termos-e-condicoes-de-uso">Termos de Uso do Asaas</a>.</label>
                </div>
                <input class="btn btn-primary btn-padding-y 10 save " type="submit" name="create" value="Criar conta" id="create">
            </form>
        </div>
    </body>
</html>