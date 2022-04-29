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
                    <tr>
                        <th scope="col">#ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Número de Cobranças</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <g:each var="customer" in="${ customerList }">
                        <tr data-url="${ g.createLink([controller:'customer', action:'show', params:[id: customer.id]])}">
                            <th scope="row">${ customer.id }</th>
                            <td>${ customer.name }</td>
                            <td>${ customer.cpfCnpj }</td>
                            <td>${ customer.email }</td>
                            <td>${ customer.phone }</td>
                            <td>${}</td>
                            <td><a href="${ g.createLink([controller:'customer', action:'show', params:[id: customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a></td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
    <asset:javascript src="asinha/customer-list.js"/>
    </body>


</html>