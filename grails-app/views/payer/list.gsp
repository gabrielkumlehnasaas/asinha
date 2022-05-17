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
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each var="payer" in="${ payerList }">
                    <tr>
                        <td>${ payer.id }</td>
                        <td>${ payer.name }</td>
                        <td>${ payer.cpfCnpj }</td>
                        <td>${ payer.email }</td>
                        <td>${ payer.phone }</td>
                        <td></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${ totalCount }" controller="payer" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
        </div>
        <a href="${ g.createLink([controller:'customer', action:'show', params:[id: customerId]]) }"><button class="btn btn-primary btn-padding-y">Voltar</button></a>
    </body>
</html>
