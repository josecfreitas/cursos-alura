<?php
function insereProduto($conexao, $nome, $valor, $descricao, $categoria_id, $usado){
	$query = "insert into produtos (nome, preco, descricao, categoria_id, usado) values ('{$nome}', {$valor}, '{$descricao}', {$categoria_id}, {$usado});";
	return mysqli_query($conexao, $query);
}
function alteraProduto($conexao, $id, $nome, $valor, $descricao, $categoria_id, $usado){
	$query = "update produtos set nome = '{$nome}', preco = {$valor}, descricao = '{$descricao}', categoria_id = {$categoria_id}, usado = {$usado} where id = {$id};";
	return mysqli_query($conexao, $query);
}

function listaProdutos($conexao){
	// $produtos = array(); sintaxe antiga
	$produtos = [];

	$result = mysqli_query($conexao, "select p.*, c.nome as categoria_nome from produtos p join categorias c on p.categoria_id = c.id");
	while ($produto = mysqli_fetch_assoc($result)) {
		array_push($produtos, $produto);
	}

	return $produtos;
}

function buscaProduto($conexao, $id){
	$result = mysqli_query($conexao, "select * from produtos where id = {$id}");
	return mysqli_fetch_assoc($result);
}

function removeProduto($conexao, $id) {
	$query = "delete from produtos where id = {$id}";
	return mysqli_query($conexao, $query);
}