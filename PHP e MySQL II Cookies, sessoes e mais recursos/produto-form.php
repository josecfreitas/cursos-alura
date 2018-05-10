<?php 
require_once('estrutura/cabecalho.php');
require_once('categoriaDAO.php');
require_once('logica-usuario.php');

verificaUsuario();

$categorias = listaCategorias($conexao);
?>

<form action="add-produto" method="POST">
    <?php require_once("produto-form-base.php") ?>
</form>

<?php require_once('estrutura/rodape.php'); ?>