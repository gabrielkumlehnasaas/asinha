<html>
  <head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title><g:message code='springSecurity.login.title'/></title>
  </head>

  <body>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Login</h5>
            <g:if test="${flash.warning}">
              <div class="alert alert-danger" style="font-size: medium;color: red;">${flash.warning}</div>
            </g:if>
            <g:if test="${flash.message}">
              <div class="alert alert-success" role="status" style="font-size: medium;color: green;">${flash.message}</div>
            </g:if>
            <form class="form-signin" action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" autocomplete="off">
              <div class="form-group">
                <label for="username">E-mail</label>
                <input type="email" class="form-control" name="${usernameParameter ?: 'username'}" id="username" autocapitalize="none"/>
              </div>
              <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" class="form-control" name="${passwordParameter ?: 'password'}" id="password"/>
                <i id="passwordToggler" title="toggle password display" onclick="passwordDisplayToggle()">&#128065;</i>
              </div>
              <div class="form-group form-check">
                <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>/> Lembrar-me
                </label>
              </div>
              <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Entrar</button>
              <hr class="my-4">
              <p>Não tem uma conta? <g:link controller="register">Registre-se</g:link></p>
            </form>
          </div>
        </div>
      </div>
    </div>
  <asset:javascript src="auth-login.js"/>
  </body>
</html>