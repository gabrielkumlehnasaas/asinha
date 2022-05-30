<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title>Register</title>
</head>

<body>
    <div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
      <div class="card card-signin my-5">
        <div class="card-body">
          <h5 class="card-title text-center">Registre-se aqui</h5>
                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                    </g:if>
              <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">
                        </div>
            <div class="form-group">
                    <label for="username">Usuário</label>
              <input type="text" class="form-control" name="username" id="username" autocapitalize="none"/>
            </div>

            <div class="form-group">
                          <label for="password">Senha</label>
              <input type="password" class="form-control" name="password" id="password"/>
            </div>

            <div class="form-group">
                          <label for="password">Confirmar Senha</label>
              <input type="password" class="form-control" name="repassword" id="repassword"/>
            </div>

                      <div class="form-group">
                          <label for="username">Nome Completo</label>
              <input type="text" class="form-control" name="fullname" id="fullname" autocapitalize="none"/>
            </div>

            <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrar</button>
            <hr class="my-4">
            <p>Ja tem uma conta? <g:link controller="login" action="auth">Conecte-se</g:link></p>
          </form>
        </div>
      </div>
    </div>
  </div>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function(event) {
            document.forms['loginForm'].elements['username'].focus();
        });
    </script>
</body>
</html>