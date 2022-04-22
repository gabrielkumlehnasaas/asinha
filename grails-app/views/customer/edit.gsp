<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <asset:javascript src="application.js"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4">
            <h4>Detalhes do Cliente</h4>
            <form class="form row" id="create-form" action="${ g.createLink([controller:'customer', action:'update']) }">
                <input type="hidden" name="id" id="id" data-customer="${ customer.id }">
                <div class="card w-100 mb-2">
                    <div class="card-header row">
                        <h5 class="card-text col-md">Nome: <input type="text" class="border border-1 border-dark" id="name" name="name" data-customer="${ customer.name }" required></h5>
                        <h5 class="card-text col-md">
                            <g:if test="${ customer.cpfCnpj.length() == 11 }">CPF: </g:if>
                            <g:if test="${ customer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                            <input type="text" class="border border-1 border-dark" id="cpfCnpj" name="cpfCnpj" data-customer="${ customer.cpfCnpj }" required></h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Contato</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md">E-mail: <input type="email" class="border border-1 border-dark" id="email" name="email" data-customer="${ customer.email }" required></h5>
                            <h5 class="card-text col-md">Telefone: <input type="text" class="border border-1 border-dark" id="phone" name="phone" data-customer="${ customer.phone }" required></h5>
                        </div>
                    </div>
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Endereço</h5>
                        </div>
                        <div class="card-body">
                            <h5 class="card-text"><input type="text" class="border border-1 border-dark" id="address" name="address" data-customer="${ customer.address }" required>
                                                , <input type="text" class="border border-1 border-dark" id="addressNumber" name="addressNumber" data-customer="${ customer.addressNumber }" required></h5>
                            <h5 class="card-text">Complemento: <input type="text" class="border border-1 border-dark" id="complement" name="complement" data-customer="${ customer.complement }"></h5>
                            <h5 class="card-text">Bairro: <input type="text" class="border border-1 border-dark" id="province" name="province" data-customer="${ customer.province }" required></h5>
                            <h5 class="card-text">Cidade: <input type="text" class="border border-1 border-dark" id="city" name="city" data-customer="${ customer.city }" required></h5> 
                            <h5 class="card-text">Estado: <input type="text" class="border border-1 border-dark" id="state" name="state" data-customer="${ customer.state }" required></h5>
                            <h5 class="card-text">CEP: <input type="text" class="border border-1 border-dark" id="cep" name="postalCode" data-customer="${ customer.postalCode }" required></h5>
                        </div>
                    </div>
                    <input class="btn btn-primary btn-padding-y" type="submit" name="update" id="update">
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/customer-edit.js"/>
    </body>
</html>