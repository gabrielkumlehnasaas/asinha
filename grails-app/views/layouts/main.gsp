<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Asinha"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="layout-main.css"/>


    <g:layoutHead/>
</head>

<body>

<header>
		<nav class="navbar">
            <asset:image src="simbolo-asinha.png" class="img-header"/>
			<h1 class="title-header">Asinha</h1>
		</nav>
</header>

<g:layoutBody/>

<footer class="text-center">
    Asinha © 2022
</footer>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
