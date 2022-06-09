<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4" id="payer-show-container">
            <h4>Detalhes do Cliente</h4>
            <form class="form row shadow-lg" id="create-form" data-redirect="${ g.createLink([controller:'payer', action:'show', params:[payerId: payer.id]]) }" action="${ g.createLink([controller:'payer', action:'update']) }">
                <div class="card w-100 mb-2">
                    <div class="card-header row shadow-lg" >
                        <h5 class="card-text col-md-2 ">Nome: <input type="text" class="form-control" id="name" name="name" value="${ payer.name }" required disabled></h5>
                        <h5 class="card-text col-md-2">
                            <g:if test="${ !payer.cpfCnpj }">CPF/CNPJ: </g:if>
                            <g:else>
                                <g:if test="${ payer.cpfCnpj.length() == 11 }">CPF: </g:if>
                                <g:if test="${ payer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                            </g:else>
                            <input type="text" class="form-control" id="cpfCnpj" name="cpfCnpj" value="${ payer.cpfCnpj }" required disabled></h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2  shadow-lg">
                        <div class="card-header">
                            <h5 class="card-title">Contato</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">E-mail: <input type="email" class="form-control" id="email" name="email" value="${ payer.email }" required disabled></h5>
                            <h5 class="card-text col-md-2">Telefone: <input type="text" class="form-control" id="phone" name="phone" value="${ payer.phone }" required disabled></h5>
                        </div>
                    </div>
                    <div class="card mb-2  shadow-lg">
                        <div class="card-header">
                            <h5 class="card-title">Endereço</h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">CEP: <input type="text" class="form-control" id="cep" name="postalCode" value="${ payer.postalCode }" required disabled></h5>
                            <h5 class="card-text col-md-2 ">Rua: <input type="text" class="form-control" id="address" name="address" value="${ payer.address }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">Bairro: <input type="text" class="form-control" id="province" name="province" value="${ payer.province }" required disabled></h5>
                            <h5 class="card-text col-md-2 ">Número: <input type="text" class="form-control" id="addressNumber" name="addressNumber" value="${ payer.addressNumber }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-2">Cidade: <input type="text" class="form-control" id="city" name="city" value="${ payer.city }" required disabled></h5>
                            <h5 class="card-text col-md-2">Estado: <input type="text" class="form-control" id="state" name="state" value="${ payer.state }" required disabled></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md-4">Complemento: <input type="text" class="form-control" id="complement" name="complement" value="${ payer.complement }" disabled></h5>
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
