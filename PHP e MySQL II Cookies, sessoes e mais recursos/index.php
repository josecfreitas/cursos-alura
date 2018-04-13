<?php 
include 'estrutura/cabecalho.php';
include 'logica-usuario.php';
?>

<div class="container">
	<h1>Bem vindo</h1>
	<p>Esse sisteminha para aprender PHP igual gente.</p>
	
	<h2>Login</h2>


	<?php
	if(isset($_GET["logout"]) && $_GET["logout"] == true) {
	?>
		<p class="alert alert-success">Usuário deslogado com sucesso!</p>
	<?php
	}
	if(isset($_GET["logado"]) && $_GET["logado"] == true) {
	?>
		<p class="alert alert-success">Usuário logado com sucesso!</p>
	<?php
	}
	if(isset($_GET["logado"]) && $_GET["logado"] == false) {
	?>
		<p class="alert alert-danger">Erro no login!</p>
	<?php }

	if(isset($_GET["falhaDeSegurança"]) && $_GET["falhaDeSegurança"] == true) {
	?>
		<p class="alert alert-danger">Apenas usuários logados tem acesso à essa funcionalidade!</p>
	<?php } ?>


	<?php if(usuarioEstaLogado()) { ?>
		<p class="text-success">
			Você está logado como <?=$_COOKIE["usuario_logado"]?>.
			<a href="logout.php">Deslogar</a>
				
			</p>
	<?php } else {?>
		<form class="login" action="login.php" method="POST">
			<div class="form-group">
				<label id="email">E-mail</label>
				<input id="email" type="email" name="email" class="form-control">
			</div>
			<div class="form-group">
				<label id="senha">Senha</label>
				<input id="senha" type="password" name="senha" class="form-control">
			</div>
			<button class="btn btn-primary" type="submit">Logar</button>
		</form>
	<?php } ?>
	
</div>

<?php include 'estrutura/rodape.php'; ?>