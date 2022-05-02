<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main"/> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Clientes</title>
        <asset:javascript src="application.js"/>
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
                <g:each var="payer" in="${ payerList }">
                    <tr>
                        <td>${ payer.id }</td>
                        <td>${ payer.name }</td>
                        <td>${ payer.cpfCnpj }</td>
                        <td>${ payer.email }</td>
                        <td>${ payer.phone }</td>
                        <td><button type="button" class="btn btn-sm">Editar</button></td>
                    </tr>
                </g:each>
            </table>

            <div class="pagination">
            <g:paginate total="${ totalCount }" controller="payer" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
            </div>


    </body>
</html>