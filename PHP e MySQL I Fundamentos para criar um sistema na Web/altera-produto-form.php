<?php 
include 'estrutura/cabecalho.php';
include 'conecta.php';
include 'categoriaDAO.php';
include 'produtoDAO.php';

$produto = buscaProduto($conexao, $_GET['idProduto']);

$categorias = listaCategorias($conexao);

$usado = $produto['usado'] ? "checked" : "";

?>


<form action="altera-produto.php" method="POST">
    <input type="hidden" name="id" value="<?=$produto['id']?>">
  <table class="table">
    <tr>
        <td>Nome</td>
        <td><input type="text" class="form-control" name="nome" value="<?=$produto['nome']?>" /></td>
    </tr>

    <tr>
        <td>Preço</td>
        <td><input type="number" class="form-control" name="preco" value="<?=$produto['preco']?>" /></td>
    </tr>

    <tr>
        <td>Descrição</td>
        <td><textarea class="form-control" name="descricao"><?=$produto['descricao']?></textarea></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="checkbox" name="usado" value="true" <?=$usado?>> Usado</td>
    </tr>

    <tr>
        <td>Categoria</td>
        <td>
            <select name="categoria_id" class="form-control">
                <option value="" disabled>Escolha uma categoria</option>
                <?php foreach ($categorias as $categoria) :
                $selected = $categoria['id'] == $produto['categoria_id'] ? "selected" : "";
                ?>
                <option value="<?=$categoria['id']?>" <?=$selected?>>
                    <?=$categoria['nome']?>
                </option>
            <?php endforeach ?>
        </select>
    </td>
</tr>

<tr>
    <td><input type="submit" value="Alterar" class="btn btn-primary" /></td>
</tr>

</table>
</form>

<?php include 'estrutura/rodape.php'; ?>