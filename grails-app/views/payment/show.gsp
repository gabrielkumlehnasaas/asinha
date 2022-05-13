<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <%@ page import="com.asinha.enums.PaymentMethod" %>
        <%@ page import="com.asinha.enums.PaymentStatus" %>
        <%@ page import="com.asinha.utils.CustomDateUtils" %>
        <title>Cobrança</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4" id="payer-show-container">
            <h4>Detalhes da cobrança</h4>
                 <div class="card w-100 mb-2">
                    <div class="card-header row">
                        <h5 class="card-text col-md">Descrição: ${ payment.description }</h5>
                    </div>
                    <div class="card-body row">
                        <h5 class="card-text col-md">Valor: R$${ payment.value }</h5>
                        <h5 class="card-text col-md">Status: <g:message code="PaymentStatus.${payment.status}"/></h5>
                        <h5 class="card-text col-md">Forma de Pagamento: <g:message code="PaymentMethod.${payment.method}"/></h5>
                    </div>
                    <div class="card-body row">    
                        <h5 class="card-text col-md">Criada em: ${ CustomDateUtils.formatTimestamp(payment.dateCreated) }</h5>
                        <h5 class="card-text col-md">Vencimento: ${ CustomDateUtils.formatTimestamp(payment.dueDate) }</h5>
                        <h5 class="card-text col-md">Data do Pagamento: ${ CustomDateUtils.formatTimestamp(payment.paymentDate) }</h5>
                    </div>
                </div>
                <div class="card-deck">
                    <div class="card mb-2">
                        <div class="card-header">
                            <h5 class="card-title">Pagador <a href="${ g.createLink([controller:'payer', action:'show', params:[payerId: payment.payer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Visualizar</button></a></h5>
                        </div>
                        <div class="card-body row">
                            <h5 class="card-text col-md">Nome: ${payment.payer.name}</h5>
                            <h5 class="card-text col-md">
                                <g:if test="${ payment.payer.cpfCnpj.length() == 11 }">CPF: </g:if>
                                <g:if test="${ payment.payer.cpfCnpj.length() == 14 }">CNPJ: </g:if>
                                ${ payment.payer.cpfCnpj }
                            </h5>
                            <h5 class="card-text col-md">Email: ${ payment.payer.email }</h5>
                        </div>
                    </div>
                    <a href="${ g.createLink([controller:'payment', action:'list', params:[customerId: payment.customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Voltar</button></a>
                    <input type="hidden" name="status" id="status" value="${g.message(code: "PaymentStatus.${ payment.status }")}">
                    <form class="form" id="confirm-form" data-redirect="${ g.createLink([controller:'payment', action:'show', params:[paymentId: payment.id]]) }"  action="${ g.createLink([controller:'payment', action:'confirm']) }">
                        <input type="hidden" name="paymentId" id="paymentId" value="${ payment.id }">
                    </form>
                    <button type="sumbit" id="confirmbtn" class="btn btn-success btn-padding-y">Confirmar pagamento</button>
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/payment-confirm.js"/>
    </body>
</html>
