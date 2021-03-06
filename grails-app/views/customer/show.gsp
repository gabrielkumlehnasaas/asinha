<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Meus dados</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4" id="customer-show-container">
            <h4>Meus dados</h4>
            <form class="form row  shadow-lg" id="create-form" data-redirect="${ g.createLink([controller:'customer', action:'show']) }" action="${ g.createLink([controller:'customer', action:'update']) }">
                <div class="card w-100 mb-2">
                    <div class="card-header row shadow-lg" >
                        <h5 class="card-text col-md-2 ">Nome: <input type="text" class="form-control" id="name" name="name" value="${ customer.name }" required disabled></h5>
                        <h5 class="card-text col-md-2">
                            <g:if test="${ !customer.cpfCnpj }">CPF/CNPJ: </g:if>
                            <g:else>
                                <g:if test="${ customer.cpfCnpj.length() == 11 }">CPF: </g:if>
                                <g:if test="${ customer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                            </g:else>
                            <input type="text" class="form-control" id="cpfCnpj" name="cpfCnpj" value="${ customer.cpfCnpj }" required disabled></h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2  shadow-lg">
                        <div class="card-header">
                            <h5 class="card-title">Contato</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">E-mail: <input type="email" class="form-control" id="email" name="email" value="${ customer.email }" required disabled></h5>
                            <h5 class="card-text col-md-2">Telefone: <input type="text" class="form-control" id="phone" name="phone" value="${ customer.phone }" required disabled></h5>
                        </div>
                    </div>
                    <div class="card mb-2  shadow-lg">
                        <div class="card-header">
                            <h5 class="card-title">Endere??o</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">CEP: <input type="text" class="form-control" id="cep" name="postalCode" value="${ customer.postalCode }" required disabled></h5>
                            <h5 class="card-text col-md-2 ">Rua: <input type="text" class="form-control" id="address" name="address" value="${ customer.address }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">Bairro: <input type="text" class="form-control" id="province" name="province" value="${ customer.province }" required disabled></h5>
                            <h5 class="card-text col-md-2 ">N??mero: <input type="text" class="form-control" id="addressNumber" name="addressNumber" value="${ customer.addressNumber }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">Cidade: <input type="text" class="form-control" id="city" name="city" value="${ customer.city }" required disabled></h5>
                            <h5 class="card-text col-md-2">Estado: <input type="text" class="form-control" id="state" name="state" value="${ customer.state }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-4">Complemento: <input type="text" class="form-control" id="complement" name="complement" value="${ customer.complement }" disabled></h5>
                        </div>
                    </div>
                    <g:render template="/utils/dashboard"/>
                    <button class="btn btn-primary btn-padding-y" type="button" name="editbtn" id="editbtn">Editar</button>
                    <button class="btn btn-primary btn-padding-y" hidden type="submit" name="updatebtn" id="updatebtn">Salvar</button>
                    <a href="${ g.createLink([controller:'payer', action:'create']) }"><button type="button" class="btn btn-primary btn-padding-y">Criar cliente</button></a>
                    <a href="${ g.createLink([controller:'payer', action:'list']) }"><button type="button" class="btn btn-primary btn-padding-y">Meus clientes</button></a>
                    <a href="${ g.createLink([controller:'payment', action:'create']) }"><button type="button" class="btn btn-primary btn-padding-y">Nova cobran??a</button></a>
                    <a href="${ g.createLink([controller:'payment', action:'list']) }"><button type="button" class="btn btn-primary btn-padding-y">Minhas cobra??as</button></a>
                </div>
            </form>
        </div>
        <asset:javascript src="utils/search-cep.js"/>
        <asset:javascript src="asinha/customer-show-and-edit-controller.js"/>
        <asset:javascript src="utils/client-form-utils.js"/>
    </body>
</html>
