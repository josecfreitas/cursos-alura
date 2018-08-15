<table class="table">
    <tr>
        <td>Nome</td>
        <td><input type="text" class="form-control" name="nome" value="<?=$produto->getNome()?>" /></td>
    </tr>

    <tr>
        <td>Preço</td>
        <td><input type="number" class="form-control" name="preco" value="<?=$produto->getPreco()?>" /></td>
    </tr>

    <tr>
        <td>Descrição</td>
        <td><textarea class="form-control" name="descricao"><?=$produto->getDescricao()?></textarea></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="checkbox" name="usado" value="true" <?=$usado?>> Usado</td>
    </tr>

    <tr>
        <td>Categoria</td>
        <td>
            <select name="categoria_id" class="form-control" required>
                <option value="">Escolha uma categoria</option>
                <?php
                foreach ($categorias as $categoria) :
                    $selected = $categoria->getId() == $produto->getCategoria()->getId() ? "selected" : "";
                    ?>
                    <option value="<?=$categoria->getId()?>" <?=$selected?>>
                        <?=$categoria->getNome()?>
                    </option>
                    <?php 
                endforeach 
                ?>
            </select>
        </td>
    </tr>

    <tr>
        <td><input type="submit" value="Alterar" class="btn btn-primary" /></td>
    </tr>

</table>