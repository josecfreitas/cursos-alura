<?php 
require_once("estrutura/cabecalho.php");
require_once("class/Produto.php");
require_once("class/Categoria.php");
require_once("produtoDAO.php");

$categoria = new Categoria();
$categoria->setId($_POST["categoria_id"]);

$nome = ($_POST["nome"];
$preco = $_POST["preco"];
$descricao = $_POST["descricao"];
if(array_key_exists("usado", $_POST)){
	$usado = "true";
} else {
	$usado = "false";
}
$produto = new Produto($nome, $preco, $descricao, $categoria, $usado);

if(alteraProduto($conexao, $produto)){
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