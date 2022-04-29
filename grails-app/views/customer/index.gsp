<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main" /> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <title>Asinha</title>
    </head>
    <body>
        <div class="container-fluid">
            <a href="${ g.createLink([controller:'customer', action:'create']) }"><button class="btn btn-primary btn-padding-y">Criar conta</button></a>
            <a href="${ g.createLink([controller:'customer', action:'list']) }"><button class="btn btn-primary btn-padding-y">Listar clientes</button></a>
            <a href="${ g.createLink([controller:'payer', action:'create']) }"><button class="btn btn-primary btn-padding-y">Criar pagador</button></a>
        </div>
    </body>
</html>