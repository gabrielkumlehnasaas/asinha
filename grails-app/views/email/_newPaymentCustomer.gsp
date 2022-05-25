<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Você possui uma nova Cobrança</title>
</head>
<body>
    <p>Olá ${ payment.payer.name }!</p>
    <p>Uma nova cobrança foi criada em seu nome por ${ payment.customer.name }</p>
    <p>Esta cobrança possui o o valor de R$ ${ payment.value }</p>
    <p>com data de vencimento para ${ payment.dueDate }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>