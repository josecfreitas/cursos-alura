<?php
include 'conecta.php';
include 'usuarioDAO.php';
include 'logica-usuario.php';

$usuario = buscaUsuario($conexao, $_POST['email'], $_POST['senha']);

if($usuario == null) {
	header("Location: index.php?logado=0");
} else {
	logarUsuario($usuario["email"]);
	header("Location: index.php?logado=1");
}

die();