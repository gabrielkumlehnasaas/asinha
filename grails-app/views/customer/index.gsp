<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
            <table>
                <tr>
                    <th>Name</th>
                    <th>CPF CNPJ</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Postal Code</th>
                    <th>State</th>
                    <th>City</th>
                    <th>Province</th>
                    <th>Address</th>
                    <th>Address Number</th>
                    <th>Birth Date</th>
                </tr>
                <g:each var="customer" in="${ customerList }">
                    <tr>
                        <td>${ customer.name }</td>
                        <td>${ customer.cpfCnpj }</td>
                        <td>${ customer.email }</td>
                        <td>${ customer.phone }</td>
                        <td>${ customer.postalCode }</td>
                        <td>${ customer.state }</td>
                        <td>${ customer.city } </td>
                        <td>${ customer.province }</td>
                        <td>${ customer.address }</td>
                        <td>${ customer.addressNumber }</td>
                        <td>${ customer.birthDate }</td>
                    </tr>
                   
                </g:each>

            </table>
    </body>
</html>