<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main" /> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
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
                        <th scope="col">Número de Cobranças</th>
                        <%-- <th scope="col"></th> --%>
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
                            <td>${}</td>
                            <%-- <td><a href="${ g.createLink([controller:'payer', action:'edit', params:[id: payer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a></td> --%>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <a href="${ g.createLink([controller:'payer', action:'index']) }"><button class="btn btn-primary btn-padding-y">Home</button></a>
    </body>
</html>
