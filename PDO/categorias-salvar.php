<?php

require_once("classes/Categoria.php");

$categoria = new Categoria();

$categoria->nome = $_POST['nome'];

$categoria->inserir();

header("Location: categorias.php");