<?php
require_once('usuarioDAO.php');
require_once('logica-usuario.php');

$usuario = buscaUsuario($conexao, $_POST['email'], $_POST['senha']);

if($usuario == null) {
	$_SESSION["danger"] = "Dados de acesso inválidos!";
	header("Location: index.php");
} else {
	logarUsuario($usuario["email"]);
	$_SESSION["success"] = "Usuário logado com sucesso!";
	header("Location: index.php");
}

die();