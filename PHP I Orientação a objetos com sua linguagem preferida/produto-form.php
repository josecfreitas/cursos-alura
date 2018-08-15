<?php 
require_once('estrutura/cabecalho.php');
require_once('class/Categoria.php');
require_once('class/Produto.php');
require_once('categoriaDAO.php');
require_once('logica-usuario.php');

verificaUsuario();

$categorias = listaCategorias($conexao);

$categoria = new Categoria();
$categoria->setId(0);

$produto = new Produto("", "", "", $categoria, "");
?>

<form action="add-produto" method="POST">
    <?php require_once("produto-form-base.php") ?>
</form>

<?php require_once('estrutura/rodape.php'); ?>