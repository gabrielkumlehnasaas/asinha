<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <%-- <meta name="layout" content="main" /> --%>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>




        
            <table>
                <thead>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>CEP</th>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Bairro</th>
                    <th>Endereço</th>
                    <th>Número</th>
                    <th>Complemento</th>
                </thead>
                <tbody>
                    <tr>
                        <td>${ customer.name }</td>
                        <td>${ customer.cpfCnpj }</td>
                        <td>${ customer.email }</td>
                        <td>${ customer.phone }</td>
                        <td>${ customer.postalCode }</td>
                        <td>${ customer.state }</td>
                        <td>${ customer.city }</td>
                        <td>${ customer.province }</td>
                        <td>${ customer.address }</td>
                        <td>${ customer.addressNumber }</td>
                        <td>${ customer.complement }</td>
                    </tr>
                 </tbody>
            </table>
        </div>
    </body>
</html>
