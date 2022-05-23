<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Você possui uma nova Cobrança</title>
</head>
<body>
    <p>Olá ${ payment.payer.name }!</p>
    <p>Uma nova cobrança foi criada em seu nome por ${ payment.customer.name }</p>
    <p>Esta cobrança é referente a "${ payment.description }", no valor de R$ ${ payment.value }</p>
    <p>e possui data de vencimento ${ payment.dueDate }</p>
    <br>
    <p>Esta é uma mensagem automatizada de Asinha Cobranças</p>
</body>
</html>
