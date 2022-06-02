<%@ page contentType="text/html" %>
<!doctype html>
<head>
    <title>Sua Cobrança Venceu</title>
</head>
<body>
    <p>Olá ${ payment.customer.name }!</p>
    <p>Sua Cobrança para ${ payment.payer.name } venceu</p>
    <p>Descrição: ${ payment.description }</p>
    <p>Valor: R$ ${ payment.value }</p>
    <br>
    <p>Cobrança intermediada por asinha.com - gerar boletos nunca foi tão fácil.</p>
</body>
</html>
