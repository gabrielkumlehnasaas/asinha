<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Asinha</title>
    </head>
    <body>
        <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">#ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telefone</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each var="payer" in="${ payerList }">
                        <tr data-url="${ g.createLink([controller:'payer', action:'show', params:[id: payer.id]])}">
                            <th scope="row">${ payer.id }</th>
                            <td>${ payer.name }</td>
                            <td>${ payer.cpfCnpj }</td>
                            <td>${ payer.email }</td>
                            <td>${ payer.phone }</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <a href="${ g.createLink([controller:'payer', action:'index']) }"><button class="btn btn-primary btn-padding-y">Home</button></a>
    </body>
</html>
