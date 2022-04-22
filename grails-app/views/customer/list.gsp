<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Clientes</title>
    </head>
    <body>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Número de Cobranças</th>
                    <th></th>
                </tr>
                <g:each var="customer" in="${ customerList }">
                    <tr>
                        <td>${ customer.id }</td>
                        <td>${ customer.name }</td>
                        <td>${ customer.cpfCnpj }</td>
                        <td>${ customer.email }</td>
                        <td>${ customer.phone }</td>
                        <td>${}</td>
                        <td><button type="button" class="btn btn-sm">Editar</button></td>
                    </tr>
                </g:each>
            </table>
            <div class="row d-flex justify-content-between">
                <div class='col d-flex justify-content-center'>
                    <g:if test="${ page > 1 }">
                        <a href="${ g.createLink([controller:'customer', action:'list', params:[id: page-1]]) }"><button class="btn btn-primary btn-padding-y">Anterior</button></a>
                    </g:if>
                </div>
                <div class='col d-flex justify-content-center'>
                    <p>${ page }</p>
                </div>
                <div class='col d-flex justify-content-center'>
                    <g:if test="${ totalPages - page > 0 }">
                        <a href="${ g.createLink([controller:'customer', action:'list', params:[id: page+1]]) }"><button class="btn btn-primary btn-padding-y">Próxima</button></a>
                    </g:if>
                </div>
            </div>

    </body>
</html>