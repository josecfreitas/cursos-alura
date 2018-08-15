<?php
error_reporting(E_ALL ^ E_NOTICE);
require_once('mensagem.php');
require_once("conecta.php");

spl_autoload_register(function ($nomeDaClasse) {
    require_once("class/" . $nomeDaClasse . ".php");
});

?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Projetinho</title>

	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/loja.css">
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a href="index.php" class="navbar-brand">Minha Loja</a>
            </div>

               <div>
                <ul class="nav navbar-nav">
                     <li><a href="produto-form.php">Adiciona Produto</a></li>
                     <li><a href="lista-produto.php">Produtos</a></li>
                    <li><a href="sobre.php">Sobre</a></li>
                </ul>
            </div>
        </div><!-- container acaba aqui -->
    </div>

	<div class="container">
		<div class="principal">            
            <?php
            mostraAlerta("success");
            mostraAlerta("danger");
            ?>