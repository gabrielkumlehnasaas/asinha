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
                <th></th>
            </tr>
            <g:each var="customer" in="${ customerList }">
                <tr>
                    <td>${ customer.id }</td>
                    <td>${ customer.name }</td>
                    <td>${ customer.cpfCnpj }</td>
                    <td>${ customer.email }</td>
                    <td>${ customer.phone }</td>
                    <td><button type="button" class="btn btn-sm">Editar</button></td>
                </tr>
            </g:each>
        </table>
        <div class="pagination">
            <g:paginate total="${ totalCount }" controller="customer" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
        </div>
    </body>
</html>
