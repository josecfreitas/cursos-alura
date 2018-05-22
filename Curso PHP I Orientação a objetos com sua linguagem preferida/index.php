<?php 
require_once('estrutura/cabecalho.php');
require_once('logica-usuario.php');
?>

<div class="container">
	<h1>Bem vindo</h1>
	<p>Esse sisteminha para aprender PHP igual gente.</p>
	
	<h2>Login</h2>

	<?php if(usuarioEstaLogado()) { ?>
		<p class="text-success">
			Você está logado como <?=$_SESSION["usuario_logado"]?>.
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

<?php require_once('estrutura/rodape.php'); ?>