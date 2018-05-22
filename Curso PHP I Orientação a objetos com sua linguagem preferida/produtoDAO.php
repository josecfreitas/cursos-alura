<?php

require_once("conecta.php");
require_once("class/Produto.php");
require_once("class/Categoria.php");

function insereProduto($conexao, Produto $produto){
	$query = "insert into produtos (nome, preco, descricao, categoria_id, usado) values ('{$produto->getNome()}', {$produto->getPreco()}, '{$produto->getDescricao()}', {$produto->getCategoria()->getId()}, {$produto->isUsado()});";
	return mysqli_query($conexao, $query);
}
function alteraProduto($conexao, Produto $produto){
	$query = "update produtos set nome = '{$produto->getNome()}', preco = {$produto->getPreco()}, descricao = '{$produto->getDescricao()}', categoria_id = {$produto->getCategoria()->getId()}, usado = {$produto->isUsado()} where id = {$produto->getId()};";
	return mysqli_query($conexao, $query);
}

function listaProdutos($conexao){
	// $produtos = array(); sintaxe antiga
	$produtos = [];

	$result = mysqli_query($conexao, "select p.*, c.id as categoria_id, c.nome as categoria_nome from produtos p join categorias c on p.categoria_id = c.id");
	while ($produto_array = mysqli_fetch_assoc($result)) {
		array_push($produtos, produtoFromArray($produto_array));
	}

	return $produtos;
}

function buscaProduto($conexao, $id){
	$result = mysqli_query($conexao, "select * from produtos where id = {$id}");
	return produtoFromArray(mysqli_fetch_assoc($result));
}

function removeProduto($conexao, $id) {
	$query = "delete from produtos where id = {$id}";
	return mysqli_query($conexao, $query);
}

function produtoFromArray($produto_array){
	$categoria = new Categoria();
	$categoria->setid($produto_array['categoria_id']);
	$categoria->setNome($produto_array['categoria_nome']);

	$nome = $produto_array['nome'];
	$preco = $produto_array['preco'];
	$descricao = $produto_array['descricao'];
	$usado = $produto_array['usado'];

	$produto = new Produto($nome, $preco, $descricao, $categoria, $usado);
	$produto->setId($produto_array['id']);

	return $produto;
}