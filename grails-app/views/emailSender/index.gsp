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
            <h2>Enviar e-mail para:</h2>
            <g:form controller="emailSender" id="formSendEmailReference" action="send">
                <div class="fieldcontain">
                  <g:textField name="emailSendEmail" id="emailSendEmail" placeholder="asinha@gmail.com" required="" />
                </div>
                <div class="fieldcontain">
                  <g:textField name="subjectSendEmail" id="subjectSendEmail" placeholder="Assunto" required="" />
                </div>
                <div class="fieldcontain">
                  <g:textArea name="messageSendEmail" id="messageSendEmail" rows="5" cols="80" placeholder="Sua menssagem" required="" />
                </div>
                <fieldset>
                  <g:submitButton name="send" value="Enviar" />
                </fieldset>
            </g:form>
        </section>
    </div>

</body>
</html>
