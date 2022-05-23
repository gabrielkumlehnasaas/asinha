<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança Venceu</title>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Sua Cobrança para ${ payment.payer.name } venceu</p>
    <p>Esta cobrança é referente a "${ payment.description }", no valor de R$ ${ payment.value }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>