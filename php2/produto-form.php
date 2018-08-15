<?php 
require_once('estrutura/cabecalho.php');
require_once('logica-usuario.php');

verificaUsuario();

$categoriaDAO = new CategoriaDAO($conexao);
$categorias = $categoriaDAO->listaCategorias();

$categoria = new Categoria();
$categoria->setId(0);

$produto = new Produto("", "", "", $categoria, "");
?>

<form action="add-produto" method="POST">
    <?php require_once("produto-form-base.php") ?>
</form>

<?php require_once('estrutura/rodape.php'); ?>