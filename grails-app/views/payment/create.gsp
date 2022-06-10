<!DOCTYPE html>
<html>
    <head>
        <%@ page import="com.asinha.enums.PaymentMethod" %>
        <meta name="layout" content="main" />
        <title>Cadastro de cobranças</title>
    </head>
    <body>
        <div class="container-fluid" id="payment-create-container">
            <p id="error"></p>
            <form class="form row" id="create-form" data-redirect="${ g.createLink([controller:'payment', action:'list']])}" action="${ g.createLink([controller:'payment', action:'save']) }">
                <div class="card-header">
                    <h4 class="card-title" id="card-header-title-payment">Nova cobrança</h4>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="value">Valor</label>
                        <input class=" form-control" type="text" name="value" id="value" required>
                    </div>
                    <div class="col-md-4 p-3 bg-light ">
                        <label for="payerId">Pagador</label>
                        <select id="payerId" class="form-control" name="payerId" required>
                            <option>Selecione um Pagador</option>
                            <g:each var="payer" in="${ payerList }">
                                <option value="${ payer.id }">${ payer.name }</option>
                            </g:each>
                        </select>
                    </div>
                </div>
                <div class="card-body row">
                    <div class="col-md-3 p-3 bg-light">
                        <label for="dueDate">Vencimento</label>
                        <input class="form-control" type="date" name="dueDate" id="dueDate" required>
                    </div>
                    <div class="col-md-4 p-3 bg-light">
                        <label for="method">Forma de pagamento</label>
                        <g:select class="form-control" name="method" id="method" valueMessagePrefix="PaymentMethod" from="${ PaymentMethod.values() }" value="${method}" noSelection="['':'Selecione um método de pagamento']"/></div>
                    </div>
                </div>
                <div class="col-md-7 p-3 bg-light">
                    <label for="description">Descrição</label>
                    <input class="form-control" type="text" name="description" id="description" required>
                </div>
                <input class="btn btn-primary btn-padding-y" type="submit" name="create" id="createPayment">
                <div>
                    <a href="${ g.createLink([controller:'customer', action:'show']) }"><button type="button" id="backPayment" class="btn btn-primary btn-padding-y">Voltar</button></a>
                </div>
            </form>
        </div>
        <asset:javascript src="payment-create-import.js"/>
        <asset:image src="logocobranca.png" id="logocobranca"/>
    </body>
</html> 
