<!DOCTYPE html>
<html>
    <head>
        <%-- <meta name="layout" content="main" /> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
        <body>
            <div class="container-fluid">
                <form class="form row" id="create-form" action="${ g.createLink([controller:'customer', action:'save']) }">
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="cpf" id="cpf" checked>
                                <label class="form-check-label" for="cpf">CPF</label>
                            </div>
                        </div>
                        <div class="col-md-6 p-3 border bg-light">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="cnpj" id="cnpj">
                                <label class="form-check-label" for="cnpj">CNPJ</label>
                            </div>
                        </div>
                             
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="Name"></label>Nome</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Nome" name="name" required>
                        </div>
                       
                        <div class="col-md-6 p-3 border bg-light natural-person">
                            <label for="cpfCnpj"></label>CPF</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="000.000.000-00" name="cpfCnpj" required>
                        </div>
                        <div class="col-md-6 p-3 border bg-light natural-person">
                            <label for="birthDate"></label>Data de Nascimento</label>
                            <input type="date" class="form-control border border-1 border-dark" placeholder="Data de Nascimento" name="birthDate" required>
                        </div>
                        

                        <div class="col-md-6 p-3 border bg-light legal-person">
                            <label for="cpfCnpj"></label>CNPJ</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="00.000.000/0000-00" name="cpfCnpj" required>
                        </div>
                                  
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="email"></label>Email</label>
                            <input type="email" class="form-control border border-1 border-dark" placeholder="E-mail" name="email" required>
                        </div>
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="phone"></label>Telefone</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Telefone" name="phone" required>
                        </div>
                
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="postalCode"></label>CEP</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="CEP" name="postalCode" required>
                        </div>
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="adress"></label>Endereço</label>
                            <input type="text" class="form-control border border-1 border-dark" id="adress" placeholder="Endereço" name="adress" required>
                        </div>
                
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="addressNumber"></label>Número</label>
                            <input type="text" class="form-control border border-1 border-dark" id="addressNumber" placeholder="Número" name="addressNumber" required>
                        </div>
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="province"></label>Bairro</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Bairro" name="province" required>
                        </div>
       
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="complement"></label>Complemento</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Complemento" name="complement" required>
                        </div>
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="city"></label>Cidade</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Cidade" name="city" required>
                        </div>
                    
                     
                        <div class="col-md-6 p-3 border bg-light">
                            <label for="state"></label>Estado</label>
                            <input type="text" class="form-control border border-1 border-dark" placeholder="Estado" name="state" required>
                        </div>
                    
                    <input class="btn btn-primary btn-padding-y 10 save " type="submit" name="create" value="Criar" id="create">
                </form>
            </div>
       
    </body>
</html>
