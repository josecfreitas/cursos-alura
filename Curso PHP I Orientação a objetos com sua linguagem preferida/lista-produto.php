<?php 
require_once("estrutura/cabecalho.php");
require_once("class/Produto.php");
require_once("produtoDAO.php");

$produtos = listaProdutos($conexao);
if(array_key_exists("removido", $_GET) && $_GET['removido']=='true') :
	?>
<p class="alert alert-success">Produto removido com sucesso!</p>
<?php endif ?>
<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Valor</th>
			<th>Valor com desconto</th>
			<th>Descrição</th>
			<th>Categoria</th>
			<th colspan="2">Ações</th>
		</tr>
	</thead>
	<?php 
	foreach ($produtos as $produto) :
		?>
	<tr>
		<td><?=$produto->getNome()?></td>
		<td><?=$produto->getPreco()?></td>
		<td><?=$produto->precoComDesconto()?></td>
		<td><?=substr($produto->getDescricao(), 0, 40)?></td>
		<td><?=$produto->getCategoria()->getNome()?></td>
		<td>
			<a class="btn btn-primary" href="altera-produto-form.php?idProduto=<?=$produto->getId()?>">Alterar</a>
		</td>
		<td>
			<form action="remove-produto.php" method="POST">
				<input type="hidden" name="id" value="<?=$produto->getId()?>">
				<button class="btn btn-danger">Remover</button>
			</form>
		</td>
	</tr>
	<?php
	endforeach
	?>
</table>

<?php require_once('estrutura/rodape.php');?>