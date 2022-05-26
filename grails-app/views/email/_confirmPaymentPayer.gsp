<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança foi paga</title>
</head>
<body>
    <p>Olá ${ payment.payer.name }!</p>
    <p>Sua Cobrança de ${ payment.customer.name } foi paga</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
