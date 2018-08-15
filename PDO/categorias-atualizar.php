<?php
require_once "global.php";

$categoria = new Categoria();
$categoria->id = $_POST["id"];
$categoria->nome = $_POST["nome"];

$categoria->atualizar();

header("Location: categorias.php");