<?php 
require_once('estrutura/cabecalho.php');
require_once('categoriaDAO.php');
require_once('produtoDAO.php');

$produto = buscaProduto($conexao, $_GET['idProduto']);

$categorias = listaCategorias($conexao);

$usado = $produto['usado'] ? "checked" : "";

?>


<form action="altera-produto.php" method="POST">
    <input type="hidden" name="id" value="<?=$produto['id']?>">
    <?php include("produto-form-base.php") ?>
</form>

<?php require_once('estrutura/rodape.php'); ?>