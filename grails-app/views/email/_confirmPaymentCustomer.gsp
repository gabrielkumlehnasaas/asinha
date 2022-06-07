<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança foi paga</title>
    <%@ page import="com.asinha.enums.PaymentMethod" %>
    <%@ page import="com.asinha.enums.PaymentStatus" %>
    <%@ page import="com.asinha.utils.CustomDateUtils" %>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Sua Cobrança para ${ payment.payer.name } foi paga</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <br>
    <h1>Dados do pagamento</h1>
    <p>Forma de pagamento: <g:message code="PaymentMethod.${payment.method}"/> </p>
    <p>Data de vencimento: ${CustomDateUtils.formatTimestamp(payment.dueDate)} </p>
    <p>Data de pagamento: ${ CustomDateUtils.formatDate(payment.paymentDate, "dd/MM/yyyy HH:mm:ss") } </p>
    <br>
    <h1>Dados do pagador</h1>
    <p>Nome: ${ payment.payer.name } </p>
    <p>CPF/CNPJ ${ payment.payer.cpfCnpj } </p>
    <p>Instituição: ASAAS GESTÃO FINANCEIRA INSTITUIÇÃO DE PAGAMENTO S.A.</p>
    <br>
    <h1>Dados do recebedor</h1>
    <p>Nome: ${ payment.customer.name } </p>
    <p>CPF/CNPJ ${ payment.customer.cpfCnpj } </p>
    <p>Instituição: ASAAS GESTÃO FINANCEIRA INSTITUIÇÃO DE PAGAMENTO S.A.</p>
    <br>
    <h4>Este documento e cobrança não possuem valor fiscal e são de responsabilidade única e exclusiva de ${ payment.customer.name }.</h4>

    <p>Cobrança intermediada por asinha.com - gerar boletos nunca foi tão fácil.</p>
</body>
</html>
