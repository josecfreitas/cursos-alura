<?php 
session_start();
function verificaUsuario() {
	if(!usuarioEstaLogado()){
		header("Location: index.php?falhaDeSegurança=1");
		die();
	}
}

function logarUsuario($email){
	$_SESSION["usuario_logado"] = $email;
}

function deslogarUsuario(){
	session_destroy();
}

function usuarioEstaLogado() {
	return isset($_SESSION["usuario_logado"]);
}