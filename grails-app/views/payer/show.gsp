<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4" id="payer-show-container">
            <h4>Detalhes do Cliente</h4>
            <form class="form row" id="create-form" data-redirect="${ g.createLink([controller:'payer', action:'show', params:[payerId: payer.id]]) }" action="${ g.createLink([controller:'payer', action:'update']) }">
                <div class="card w-100 mb-2">
                    <div class="card-header row">
                        <h5 class="card-text col-md">Nome: <input type="text" class="border border-1 border-dark" id="name" name="name" value="${ payer.name }" required disabled></h5>
                        <h5 class="card-text col-md">
                            <g:if test="${ payer.cpfCnpj.length() == 11 }">CPF: </g:if>
                            <g:if test="${ payer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                            <input type="text" class="border border-1 border-dark" id="cpfCnpj" name="cpfCnpj" value="${ payer.cpfCnpj }" required disabled></h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Contato</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md">E-mail: <input type="email" class="border border-1 border-dark" id="email" name="email" value="${ payer.email }" required disabled></h5>
                            <h5 class="card-text col-md">Telefone: <input type="text" class="border border-1 border-dark" id="phone" name="phone" value="${ payer.phone }" required disabled></h5>
                        </div>
                    </div>
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Endereço</h5>
                        </div>
                        <div class="card-body">
                            <h5 class="card-text"><input type="text" class="border border-1 border-dark" id="address" name="address" value="${ payer.address }" required disabled>
                                                , <input type="text" class="border border-1 border-dark" id="addressNumber" name="addressNumber" value="${ payer.addressNumber }" required disabled></h5>
                            <h5 class="card-text">Complemento: <input type="text" class="border border-1 border-dark" id="complement" name="complement" value="${ payer.complement }" disabled></h5>
                            <h5 class="card-text">Bairro: <input type="text" class="border border-1 border-dark" id="province" name="province" value="${ payer.province }" required disabled></h5>
                            <h5 class="card-text">Cidade: <input type="text" class="border border-1 border-dark" id="city" name="city" value="${ payer.city }" required disabled></h5>
                            <h5 class="card-text">Estado: <input type="text" class="border border-1 border-dark" id="state" name="state" value="${ payer.state }" required disabled></h5>
                            <h5 class="card-text">CEP: <input type="text" class="border border-1 border-dark" id="cep" name="postalCode" value="${ payer.postalCode }" required disabled></h5>
                        </div>
                    </div>
                    <input type="hidden" name="payerId" id="payerId" value="${ payer.id }">
                    <button class="btn btn-primary btn-padding-y" type="button" name="editbtn" id="editbtn">Editar</button>
                    <button class="btn btn-primary btn-padding-y" type="submit" hidden name="updatebtn" id="updatebtn">Salvar</button>
                    <a href="${ g.createLink([controller:'payer', action:'list']) }"><button type="button" class="btn btn-primary btn-padding-y">Voltar</button></a>
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/payer-show-and-edit-controller.js"/>
    <asset:javascript src="utils/client-form-utils.js"/>
    </body>
</html>
