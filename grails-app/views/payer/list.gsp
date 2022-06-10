<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Meus pagadores</title>
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
                    <tr data-url="${ g.createLink([controller:'payer', action:'show', params:[payerId: payer.id]])}">
                        <td>${ payer.id }</td>
                        <td>${ payer.name }</td>
                        <td id="cpfCnpj">${ payer.cpfCnpj }</td>
                        <td>${ payer.email }</td>
                        <td id="phone">${ payer.phone }</td>
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
        <asset:javascript src="utils/client-form-utils.js"/>
    </body>
</html>
