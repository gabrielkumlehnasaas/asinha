<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Asinha</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="layout-main.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="nav justify-content-start">
                <asset:image class="img-header"src="simbolo-asinha.png"/>
            </div>
            <div class="nav justify-content-end">
                <h1 class="title">Asinha</h1>
            </div>
            <div class="dropdown">
                <sec:ifLoggedIn>
                <button class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false"><sec:loggedInUserInfo field='fullname'/></button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                   <a class="dropdown-item red-color" href="logoff">Sair</a>
                </div>
                </sec:ifLoggedIn>
            </div>
        </nav>
        
    </header>
    <g:layoutBody/>
    <footer>
        <h5>Asinha© 2022</h5>
    </footer>
</body>
</html>
