<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4">
            <h4>Detalhes do Cliente</h4>
            <div class="card w-100 mb-2">
                <div class="card-header row">
                    <h5 class="card-title col-md">Nome: ${ customer.name }</h5>
                    <h5 class="card-text col-md">
                        <g:if test="${ customer.cpfCnpj.length() == 11 }">CPF: </g:if>
                        <g:if test="${ customer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                        ${ customer.cpfCnpj }</h5>
                </div>
            </div>
            <div class="card-deck">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">Contato</h5>
                    </div>
                    <div class="card-body row">
                        <h5 class="card-text col-md">E-mail: ${ customer.email }</h5>
                        <h5 class="card-text col-md">Telefone: ${ customer.phone }</h5>
                    </div>
                </div>
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">Endereço</h5>
                    </div>
                    <div class="card-body">
                        <h5 class="card-text">${ customer.address }, ${ customer.addressNumber }</h5>
                        <g:if test="${ customer.complement.length()>0 }"><h5>Complemento: ${ customer.complement }</h5></g:if>
                        <h5 class="card-text">Bairro: ${ customer.province }</h5>
                        <h5 class="card-text">Cidade: ${ customer.city }</h5> 
                        <h5 class="card-text">Estado: ${ customer.state }</h5>
                        <h5 class="card-text">CEP: ${ customer.postalCode }</h5>
                    </div>
                </div>
                <a href="${ g.createLink([controller:'customer', action:'edit', params:[id: customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a>
            </div>
        </div>
    </body>
</html>
