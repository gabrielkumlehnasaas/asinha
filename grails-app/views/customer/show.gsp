<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4" id="customer-show-container">
            <h4>Detalhes do Cliente</h4>
            <form class="form row" id="create-form" action="${ g.createLink([controller:'customer', action:'update']) }">
                <input type="hidden" name="customerId" id="customerId" value="${ customer.id }">
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
                    <button class="btn btn-primary btn-padding-y" hidden name="updatebtn" id="updatebtn">Salvar</button>
                    <a href="${ g.createLink([controller:'payer', action:'create', params:[customerId: customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Criar pagador</button></a>
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/customer-show.js"/>
    </body>
</html>
