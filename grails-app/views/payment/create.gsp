<!DOCTYPE html>
<html>
    <head>
        <%@ page import="com.asinha.enums.PaymentMethod" %>
        <%--    <meta name="layout" content="main" /> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Cadastro de cobranças</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <div class="container-fluid" id="payment-create-container">
            <p id="error"></p>
            <form class="form row" id="create-form" data-redirect="${ g.createLink([controller:'payment', action:'list', params:[customerId: customerId]])}" action="${ g.createLink([controller:'payment', action:'save']) }">
                <div class="col-md-6 p-3 bg-light">
                    <label for="value">Valor</label>
                    <input class=" form-control border border-1 border-dark" type="text" name="value" id="value" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="description">Descrição</label>
                    <input class="form-control border border-1 border-dark" type="text" name="description" id="description" required>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="payerId">Pagador</label>
                    <select id="payerId" class="form-control border border-1 border-dark" name="payerId" required>
                        <option>Selecione um Pagador</option>
                        <g:each var="payer" in="${ payerList }">
                           <option value="${ payer.id }">${ payer.name }</option>
                        </g:each>
                    </select>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="method">Forma de pagamento</label>
                    <g:select class="form-control border border-1 border-dark" name="method" id="method" valueMessagePrefix="PaymentMethod" from="${ PaymentMethod.values() }" value="${method}" noSelection="['':'Selecione um método de pagamento']"/>
                </div>
                <div class="col-md-6 p-3 bg-light">
                    <label for="dueDate">Vencimento</label>
                    <input class=" form-control border border-1 border-dark" type="date" name="dueDate" id="dueDate" required>
                </div>
                <input hidden value="${ customerId }" name="customerId" id="customerId">
                <input class="btn btn-primary btn-padding-y" type="submit" name="create" id="create">
      
            </form>      
        </div>
        <asset:javascript src="payment-create-import.js"/>
    </body>
</html> 