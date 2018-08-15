<?php
require_once "global.php";

$id = $_GET['id'];
$categoria = new Categoria($id);
?>

<?php require_once 'cabecalho.php'?>
<div class="row">
    <div class="col-md-12">
        <h2>Editar Categoria</h2>
    </div>
</div>
<form action="categorias-atualizar.php" method="post">
    <input type="hidden" name="id" value="<?=$categoria->id?>">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="form-group">
                <label for="nome">Nome da Categoria</label>
                <input type="text" name="nome" value="<?=$categoria->nome?>" class="form-control" placeholder="Nome da Categoria">
            </div>
            <input type="submit" class="btn btn-success btn-block" value="Salvar">
        </div>
    </div>
</form>
<?php require_once 'rodape.php'?>
