<?php

include("conecta.php");

function buscaUsuario($conexao, $email, $senha) {
	$senhaMd5 = md5($senha);
	$email = mysqli_real_escape_string($conexao, $email);
	$query = "select * from usuarios where email = '${email}' and senha = '${senhaMd5}'";
	$result = mysqli_query($conexao, $query);
	$usuario = mysqli_fetch_assoc($result);

	return $usuario;
}