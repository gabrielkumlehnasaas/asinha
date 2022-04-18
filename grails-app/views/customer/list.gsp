<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
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
    </body>

    <script>
        $(document).ready( function() {
            $("form").on("submit", function(e) {
                e.preventDefault();

                if (!$("input[name='name']").val()) return alet("adicione nome")

                let infosCustomer = {};
                let data = new FormData(document.querySelector("form"));
                data.forEach(function (value, key) {
                    infosCustomer[key] = value
                });

                $.post("/customer/save", infosCustomer, function(response)) {
                    if (response.success) {
                        window.location.href = "/customer/list";
                        return;
                    }
                }
            })
        })


    </script>
</html>