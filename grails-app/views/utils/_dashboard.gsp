<g:if test="${ PaymentService.getPaymentsByCustomer(customer.long("id")) }">
   
    <div>
        <div>
            <div class="card">
                <div class="card-header">
                    Recebidos
                </div>
                <div class="card-body">
                    ${ PaymentService.listPaymentByCustomerAndStatus(customer.long("id"), PaymentStatus.PAID) }
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    à Receber
                </div>
                <div class="card-body">
                    ${}
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    Vencidos
                </div>
                                <div class="card-body">
                    ${}
                </div>
            </div>
        </div>
        <div>
            <div class="card"></div>
            <div class="card"></div>
        </div>
    </div>
</g:if>