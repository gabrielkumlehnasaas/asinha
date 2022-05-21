<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Email Sender</title>
</head>
<body>
    <div id="content" role="main">
        <section class="row colset-2-its">
            <g:if test="${flash.message}">
                <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                    ${flash.message}
                </div>
            </g:if>
            <g:form controller="emailSender" action="send">
                <h2>Enviar e-mail para:</h2>
                <div class="fieldcontain">
                  <g:textField name="email" id="email" placeholder="asinha@gmail.com" required=""/>
                </div>
                <div class="fieldcontain">
                  <g:textField name="subject" id="subject" placeholder="Assunto" required=""/>
                </div>
                <div class="fieldcontain">
                  <g:textArea name="message" id="message" rows="5" cols="80" placeholder="Sua menssagem" required=""/>
                </div>
                <fieldset>
                  <g:submitButton name="send" value="Enviar"/>
                </fieldset>
            </g:form>
        </section>
    </div>

</body>
</html>
