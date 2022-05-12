<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main"/> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Clientes</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <table class="table">
            <thead class="thead-light">
                <tr></tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Número de Cobranças</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each var="payer" in="${ payerList }">
                    <tr data-url="${ g.createLink([controller:'payer', action:'show', params:[payerId: payer.id]])}">
                        <td>${ payer.id }</td>
                        <td>${ payer.name }</td>
                        <td>${ payer.cpfCnpj }</td>
                        <td>${ payer.email }</td>
                        <td>${ payer.phone }</td>
                        <td><a href="${ g.createLink([controller:'payer', action:'show', params:[payerId: payer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${ totalCount }" controller="payer" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
        </div>
        <a href="${ g.createLink([controller:'customer', action:'show', params:[customerId: customerId]]) }"><button class="btn btn-primary btn-padding-y">Voltar</button></a>
        <asset:javascript src="utils/click-list.js"/>
    </body>
</html>