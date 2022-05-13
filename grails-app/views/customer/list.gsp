<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Clientes</title>
    </head>
    <body>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>#ID</th>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each var="customer" in="${ customerList }">
                    <tr data-url="${ g.createLink([controller:'customer', action:'show', params:[id: customer.id]])}">
                        <th>${ customer.id }</th>
                        <td>${ customer.name }</td>
                        <td>${ customer.cpfCnpj }</td>
                        <td>${ customer.email }</td>
                        <td>${ customer.phone }</td>
                        <td><a href="${ g.createLink([controller:'customer', action:'show', params:[id: customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${ totalCount }" controller="customer" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
        </div>
        <asset:javascript src="utils/click-list.js"/>
    </body>
</html>
