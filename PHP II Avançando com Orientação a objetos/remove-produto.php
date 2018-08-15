<?php
$id=$_POST['id'];

$produtoDAO = new ProdutoDAO($conexao);
$produtoDAO->removeProduto($id);
header("Location: lista-produto.php?removido=true");
die();