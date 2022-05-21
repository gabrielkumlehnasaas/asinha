<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Você possui uma nova Cobrança</title>
</head>
<body>
    <p>Olá ${ payment.payer.name }!</p>
    <p>A cobrança em seu nome criada por ${ payment.customer.name } venceu</p>
    <p>Esta cobrança é referente a "${ payment.description }", no valor de R$ ${ payment.value }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>