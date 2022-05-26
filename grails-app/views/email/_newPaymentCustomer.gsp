<%@ page contentType="text/html" %>
<%@ page import="com.asinha.utils.CustomDateUtils" %>
<!doctype html>
<head>
    <title>Você criou uma nova Cobrança</title>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Uma nova cobrança foi criada para ${ payment.payer.name }</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <p>Data de vencimento: ${ payment.dueDate }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
