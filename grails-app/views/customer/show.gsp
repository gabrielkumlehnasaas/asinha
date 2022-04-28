<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <asset:javascript src="application.js"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid customer-show-container mt-3 ml-4">
            <h4>Detalhes do Cliente</h4>
            <form class="form row" id="create-form" action="${ g.createLink([controller:'customer', action:'update']) }">
                <input type="hidden" name="id" id="id" value="${ customer.id }">
                <div class="card w-100 mb-2">
                    <div class="card-header row">
                        <h5 class="card-text col-md">Nome: <input type="text" class="border border-1 border-dark" id="name" name="name" value="${ customer.name }" required disabled></h5>
                        <h5 class="card-text col-md">
                            <g:if test="${ customer.cpfCnpj.length() == 11 }">CPF: </g:if>
                            <g:if test="${ customer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                            <input type="text" class="border border-1 border-dark" id="cpfCnpj" name="cpfCnpj" value="${ customer.cpfCnpj }" required disabled></h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Contato</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md">E-mail: <input type="email" class="border border-1 border-dark" id="email" name="email" value="${ customer.email }" required disabled></h5>
                            <h5 class="card-text col-md">Telefone: <input type="text" class="border border-1 border-dark" id="phone" name="phone" value="${ customer.phone }" required disabled></h5>
                        </div>
                    </div>
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Endereço</h5>
                        </div>
                        <div class="card-body">
                            <h5 class="card-text"><input type="text" class="border border-1 border-dark" id="address" name="address" value="${ customer.address }" required disabled>
                                                , <input type="text" class="border border-1 border-dark" id="addressNumber" name="addressNumber" value="${ customer.addressNumber }" required disabled></h5>
                            <h5 class="card-text">Complemento: <input type="text" class="border border-1 border-dark" id="complement" name="complement" value="${ customer.complement }" disabled></h5>
                            <h5 class="card-text">Bairro: <input type="text" class="border border-1 border-dark" id="province" name="province" value="${ customer.province }" required disabled></h5>
                            <h5 class="card-text">Cidade: <input type="text" class="border border-1 border-dark" id="city" name="city" value="${ customer.city }" required disabled></h5> 
                            <h5 class="card-text">Estado: <input type="text" class="border border-1 border-dark" id="state" name="state" value="${ customer.state }" required disabled></h5>
                            <h5 class="card-text">CEP: <input type="text" class="border border-1 border-dark" id="cep" name="postalCode" value="${ customer.postalCode }" required disabled></h5>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-padding-y" name="editbtn" id="editbtn">Editar</button>
                    <button class="btn btn-primary btn-padding-y" hidden type="submit" name="update" id="update">Enviar</button>
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/customer-show.js"/>
    </body>
</html>