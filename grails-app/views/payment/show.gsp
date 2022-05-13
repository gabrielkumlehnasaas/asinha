<!DOCTYPE html>
<html>
    <head>
        <%@ page import="com.asinha.enums.PaymentMethod" %>
        <%@ page import="com.asinha.enums.PaymentStatus" %>
        <%@ page import="com.asinha.utils.CustomDateUtils" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <asset:javascript src="application.js"/>
        <title>Cliente</title>
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
                            <h5 class="card-title">Pagador <a href="${ g.createLink([controller:'payer', action:'show', params:[id: payment.payer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Visualizar</button></a></h5>
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
                    
                    <a href="${ g.createLink([controller:'payment', action:'list', params:[id: payment.customer.id]]) }"><button type="button" class="btn btn-primary btn-padding-y">Voltar</button></a>
                </div>
            </form>
        </div>
    <asset:javascript src="asinha/payer-show.js"/>
    </body>
</html>
