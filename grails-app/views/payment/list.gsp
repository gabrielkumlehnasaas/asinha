<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main"/> --%>
        <%@ page import="com.asinha.enums.PaymentMethod" %>
        <%@ page import="com.asinha.enums.PaymentStatus" %>
        <%@ page import="com.asinha.utils.CustomDateUtils" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Clientes</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <table class="table">
            <thead class="thead-light">
                <tr></tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Valor</th>
                    <th>Pagador</th>
                    <th>Vencimento</th>
                    <th>Forma de pagamento</th>
                    <th>Status</th>
                    <th>Data do pagamento</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each var="payment" in="${ paymentList }">
                    <tr data-url="${ g.createLink([controller:'payment', action:'show', params:[id: payment.id]])}">
                        <td>${ payment.id }</td>
                        <td>${ payment.description }</td>
                        <td>${ payment.value }</td>
                        <td>${ payment.payer.name }</td>
                        <td>${ CustomDateUtils.formatTimestamp(payment.dueDate)}</td>
                        <td>${ payment.method }</td>
                        <td>${ payment.status}</td>
                        <td>${ payment.paymentDate }</td>
                        <td><a href="${ g.createLink([controller:'payment', action:'show', params:[id: payment.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Editar</button></a></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${ totalCount }" controller="payment" action="list" params="${ params }" next="Próxima" prev="Anterior" max="10" />
        </div>
        <a href="${ g.createLink([controller:'customer', action:'show', params:[id: customerId]]) }"><button class="btn btn-primary btn-padding-y">Voltar</button></a>
        <asset:javascript src="utils/click-list.js"/>
    </body>
</html>