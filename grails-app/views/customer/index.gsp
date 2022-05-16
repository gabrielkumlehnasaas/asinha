<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Asinha</title>
    </head>
    <body>
        <div class="container-fluid">
            <a href="${ g.createLink([controller:'customer', action:'create']) }"><button class="btn btn-primary btn-padding-y">Criar conta</button></a>
            <a href="${ g.createLink([controller:'customer', action:'list']) }"><button class="btn btn-primary btn-padding-y">Listar clientes</button></a>
        </div>
    </body>
</html>
