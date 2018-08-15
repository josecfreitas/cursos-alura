<?php 
session_start();
function verificaUsuario() {
	if(!usuarioEstaLogado()){
		header("Location: index.php");
		$_SESSION["danger"] = "Efetue login para acessar essa funcionalidade!";
		die();
	}
}

function logarUsuario($email){
	$_SESSION["usuario_logado"] = $email;
}

function deslogarUsuario(){
	session_destroy();
	session_start();
}

function usuarioEstaLogado() {
	return isset($_SESSION["usuario_logado"]);
}