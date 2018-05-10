<?php

include("conecta.php");

function listaCategorias($conexao){
	$categorias = [];

	$result = mysqli_query($conexao, "select * from categorias");
	while ($categoria = mysqli_fetch_assoc($result)) {
		array_push($categorias, $categoria);
	}

	return $categorias;
}