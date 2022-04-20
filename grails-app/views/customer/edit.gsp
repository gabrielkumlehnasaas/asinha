<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW2" crossorigin="anonymous">
        
        <title>Cliente</title>
    </head>
    <body>
        <div class="container-fluid mt-3 ml-4">
            <h4>Detalhes do Cliente</h4>
            <div class="card w-100 mb-2">
                <div class="card-header">
                    <h5 class="card-title">
                        ${ customer.name }
                    </h5>
                    <h6 class="card-text">
                        ${ customer.cpfCnpj }
                    </h6>
                </div>
            </div>
            <div class="card-deck">
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">
                            Contato
                        </h5>
                    </div>
                    <div class="card-body">
                        <p class="card-text">
                            ${ customer.email }
                        </p>
                        <p>
                            ${ customer.phone }
                        </p>
                    </div>
                </div>
                <div class="card mb-2">
                    <div class="card-header">
                        <h5 class="card-title">
                            Endereço
                        </h5>
                    </div>
                    <div class="card-body">
                        <p class="card-text">
                            ${ customer.address }, ${ customer.addressNumber }
                            <g:if test="${ customer.complement.length()>0 }">, ${ customer.complement }</g:if>
                        </p>
                        <p>
                            ${ customer.province }, ${ customer.city }, ${ customer.state }
                        </p>
                        <p>
                            ${ customer.postalCode }
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
