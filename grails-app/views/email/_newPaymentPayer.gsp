<%@ page contentType="text/html" %>
<%@ page import="com.asinha.utils.CustomDateUtils" %>
<!doctype html>
<head>
    <title>Você possui uma nova Cobrança</title>
</head>
<body>
    <p>Olá ${ payment.payer.name }!</p>
    <p>Uma nova cobrança foi criada em seu nome por ${ payment.customer.name }</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <p>Data de vencimento: ${ CustomDateUtils.formatDate(payment.dueDate, "dd/MM/yyyy") }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
