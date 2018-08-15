<?php 
require_once("estrutura/cabecalho.php");

$categoria = new Categoria();
$categoria->setId($_POST["categoria_id"]);

$id = $_POST["id"];
$nome = $_POST["nome"];
$preco = $_POST["preco"];
$descricao = $_POST["descricao"];
if(array_key_exists("usado", $_POST)){
	$usado = "true";
} else {
	$usado = "false";
}
$produto = new Produto($nome, $preco, $descricao, $categoria, $usado);
$produto->setId($id);

$produtoDAO = new ProdutoDAO($conexao);
if($produtoDAO->alteraProduto($produto)){
	?>
	<p class="alert-success">O produto <?=$produto->getNome()?> (R$ <?=$produto->getPreco()?>) foi alterado com sucesso</p>
	<?php
} else {
	$msg = mysqli_error($conexao);
	?>
	<p class="alert-danger">O produto <?=$produto->getNome()?> (R$ <?=$produto->getPreco()?>) não alterado: <?=$msg?></p>
	<?php
}
?>
<?php require_once('estrutura/rodape.php');?>