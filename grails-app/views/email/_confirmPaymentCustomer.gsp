<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança foi paga</title>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Sua Cobrança para ${ payment.payer.name } foi paga</p>
    <p>Este pagamento é referente a "${ payment.description }", no valor de R$ ${ payment.value }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
