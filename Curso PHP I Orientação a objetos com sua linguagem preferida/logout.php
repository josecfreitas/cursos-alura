<?php 
require_once("logica-usuario.php");
deslogarUsuario();

$_SESSION["success"] = "Usuário deslogado com sucesso!";
header("Location: index.php");
die();