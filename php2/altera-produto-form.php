<?php 
require_once('estrutura/cabecalho.php');

$produtoDAO = new ProdutoDAO($conexao);
$produto = $produtoDAO->buscaProduto($_GET['idProduto']);

$categoriaDAO = new CategoriaDAO($conexao);
$categorias = $categoriaDAO->listaCategorias();

$usado = $produto->isUsado() ? "checked" : "";

?>


<form action="altera-produto.php" method="POST">
    <input type="hidden" name="id" value="<?=$produto->getId()?>">
    <?php include("produto-form-base.php") ?>
</form>

<?php require_once('estrutura/rodape.php'); ?>