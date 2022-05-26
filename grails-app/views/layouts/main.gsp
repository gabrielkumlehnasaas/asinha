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
        </nav>
        <nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
                <ul class="nav navbar-nav ml-auto">
                <g:pageProperty name="page.nav"/>
                <sec:ifLoggedIn>
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    <sec:loggedInUserInfo field='fullname'/>
                  </a>
                  <div class="dropdown-menu navbar-dark">
                    <g:form controller="logout">
                      <g:submitButton class="dropdown-item navbar-dark color-light" name="Submit" value="Logout" style="color:gray" />
                    </g:form>
                  </div>
              </li>
                </sec:ifLoggedIn>
                </ul>
            </div>

        </nav>
    </header>
    <g:layoutBody/>
    <footer>
        <h5>Asinha© 2022</h5>
    </footer>
</body>
</html>
