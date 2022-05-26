<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Você criou uma nova Cobrança</title>
    <%@ page import="com.asinha.utils.CustomDateUtils" %>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Uma nova cobrança foi criada para ${ payment.payer.name }</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <p>Data de vencimento: ${ CustomDateUtils.formatDate(payment.dueDate, "dd/MM/yyyy") }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
