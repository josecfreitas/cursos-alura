<?php 
include 'estrutura/cabecalho.php';
include 'conecta.php';
include 'categoriaDAO.php';

$categorias = listaCategorias($conexao);
?>

<form action="add-produto" method="POST">
  <table class="table">
    <tr>
        <td>Nome</td>
        <td><input type="text" class="form-control" name="nome" /></td>
    </tr>

    <tr>
        <td>Preço</td>
        <td><input type="number" class="form-control" name="preco" /></td>
    </tr>

    <tr>
        <td>Descrição</td>
        <td><textarea class="form-control" name="descricao"></textarea></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="checkbox" name="usado" value="true"> Usado</td>
    </tr>

    <tr>
        <td>Categoria</td>
        <td>
            <select name="categoria_id" class="form-control">
                <?php foreach ($categorias as $categoria) :?>
                    <option value="<?=$categoria['id']?>">
                        <?=$categoria['nome']?>
                    </option>
                <?php endforeach ?>
            </select>
        </td>
    </tr>

    <tr>
        <td><input type="submit" value="Cadastrar" class="btn btn-primary" /></td>
    </tr>

</table>
</form>

<?php include 'estrutura/rodape.php'; ?>