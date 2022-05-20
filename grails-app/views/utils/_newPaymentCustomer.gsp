<%@ page contentType="text/html" %>
<html>
<head>
    <title>Você criou uma nova Cobrança</title>
    <%@ page import="com.asinha.utils.CustomDateUtils" %>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Uma nova cobrança foi criada para ${ payment.payer.name }</p>
    <p>Esta cobrança é referente a "${ payment.description }", no valor de R$ ${ payment.value }</p>
    <p>e possui data de vencimento ${ CustomDateUtils.formatTimestamp(payment.dueDate) }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>