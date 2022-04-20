<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        <asset:javascript src="application.js"/>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4">
            <h4>Detalhes do Cliente</h4>
            <div class="card w-100 mb-2">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">
                            <h5 class="card-title">Nome</h5>
                            <input type="text" class="form-control border border-1 border-dark" id="name" name="name" data-customer="${ customer.name }" required>
                        </div>
                    </div>
                    <div class="row">
                        <h6 class="card-text col-sm">CPF/CNPJ</h6>
                        <input type="text" class="form-control border border-1 border-dark col" id="cpfCnpj" name="cpfCnpj" data-customer="${ customer.cpfCnpj }" required>
                    </div>
                </div>
            </div>
            <div class="card-deck">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">Contato</h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <p class="card-text col">E-mail</p>
                            <input type="email" class="form-control border border-1 border-dark col" id="email" name="email" data-customer="${ customer.email }" required>
                        </div>
                        <div clas="row">
                            <p class="card-text col">Telefone</p>
                            <input type="text" class="form-control border border-1 border-dark col" id="phone" name="phone" data-customer="${ customer.phone }" required>
                        </div>
                    </div>
                </div>
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">Endereço</h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <input type="text" class="form-control border border-1 border-dark" id="address" name="address" data-customer="${ customer.address }" required>
                            <input type="text" class="form-control border border-1 border-dark" id="addressNumber" name="addressNumber" data-customer="${ customer.addressNumber }" required>
                            <input type="text" class="form-control border border-1 border-dark" id="province" name="province" data-customer="${ customer.province }" required>
                            <input type="text" class="form-control border border-1 border-dark" id="complement" name="complement" data-customer="${ customer.complement }">
                            <input type="text" class="form-control border border-1 border-dark" id="city" name="city" data-customer="${ customer.city }" required>
                            <input list="states" class="form-control border border-1 border-dark" id="state" name="state" data-customer="${ customer.state }" required>
                            <datalist id="states">
                                <option value="AC"></option> 
                                <option value="AL"></option> 
                                <option value="AM"></option> 
                                <option value="AP"></option> 
                                <option value="BA"></option> 
                                <option value="CE"></option> 
                                <option value="DF"></option> 
                                <option value="ES"></option> 
                                <option value="GO"></option> 
                                <option value="MA"></option> 
                                <option value="MT"></option> 
                                <option value="MS"></option> 
                                <option value="MG"></option> 
                                <option value="PA"></option> 
                                <option value="PB"></option> 
                                <option value="PR"></option> 
                                <option value="PE"></option> 
                                <option value="PI"></option> 
                                <option value="RJ"></option> 
                                <option value="RN"></option> 
                                <option value="RO"></option> 
                                <option value="RS"></option> 
                                <option value="RR"></option> 
                                <option value="SC"></option> 
                                <option value="SE"></option> 
                                <option value="SP"></option> 
                                <option value="TO"></option> 
                            </datalist>
                            <input type="text" class="form-control border border-1 border-dark" id="cep" name="postalCode" data-customer="${ customer.postalCode }" required>
                        </div>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    <asset:javascript src="asinha/customer-edit.js"/>
    </body>
</html>
