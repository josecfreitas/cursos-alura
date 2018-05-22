<?php

require_once("conecta.php");
require_once("class/Categoria.php");

function listaCategorias($conexao){
	$categorias = [];

	$result = mysqli_query($conexao, "select * from categorias");
	while ($categoria_array = mysqli_fetch_assoc($result)) {
		$categoria = new Categoria();

		$categoria->setId($categoria_array['id']);
		$categoria->setNome($categoria_array['nome']);

		array_push($categorias, $categoria);
	}

	return $categorias;
}