<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança Venceu</title>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Sua Cobrança para ${ payment.customer.name } venceu</p>
    <p>Esta cobrança possui o o valor de R$ ${ payment.value }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>