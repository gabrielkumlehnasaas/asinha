<!doctype html>
<html>
<head>
    <meta name="layout" content="main-asinha"/>
    <title>Asinha - Cadastro</title>
	    <asset:stylesheet src="style.css"/>
</head>
<body>
	<main class="container">
		<h1 class="title">Cadastro</h1>
		<p id="error"> </p>
		<form id="form-cadastro">
			<div class="row">
				<div class="inputbox">
					<input type="text" id="nome" autocomplete="off" required>
					<label for="nome">Nome</label>
				</div>
				<div class="inputbox">
					<input type="text" id="cpf-cnpj" minlength="11" maxlength="14" autocomplete="off" required>
					<label for="cpf-cnpj">CPF/CNPJ</label>
				</div>
				<div class="inputbox">
					<input type="email" id="email" autocomplete="off" required>
					<label for="email">Email</label>
				</div>
                <div class="inputbox">
					<input type="text" id="telefone" minlength="11" maxlength="11" autocomplete="off" required>
					<label for="telefone">Telefone</label>
				</div>
                <div class="inputbox">
					<input type="text" id="cep" minlength="8" maxlength="8" autocomplete="off" required>
					<label for="cep">CEP</label>
				</div>
				<div class="inputbox">
					<input type="text" id="estado" maxlength="2" autocomplete="off" required>
					<label for="estado">Estado</label>
				</div>
                <div class="inputbox">
					<input type="text" id="cidade" autocomplete="off" required>
					<label for="cidade">Cidade</label>
				</div>
                <div class="inputbox">
					<input type="text" id="bairro" autocomplete="off" required>
					<label for="bairro">Bairro</label>
				</div>
                <div class="inputbox">
                    <input type="text" id="endereco" autocomplete="off" required>
                    <label for="endereco">Endereço</label>
                </div>
                <div class="inputbox">
                    <input type="text" id="numero" autocomplete="off" required>
                    <label for="numero">Número</label>
                </div>
				<div class="inputbox">
                    <input type="text" id="complemento" autocomplete="off">
                    <label for="complemento">Complemento</label>
                </div>
				<div class="inputbox">
					<input type="password" id="senha" autocomplete="off" required>
					<label for="senha">Senha</label>
				</div>
				<div class="inputbox">
					<input type="password" id="conf-senha" autocomplete="off" required>
					<label for="conf-senha">Confirmar senha</label>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="termo">
					<input type="checkbox" id="termos" required>
					<label for="termos"></label>Li e concordo com os 
					<a href="https://ajuda.asaas.com/pt-BR/articles/102021-termos-e-condicoes-de-uso">Termos de Uso do Asaas</a>.</label>
				</div>
				<button id="button">Cadastrar</button>
			</div>
		</form>
	</main>
</body>
</html>
