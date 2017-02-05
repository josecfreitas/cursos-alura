<?php 
include("estrutura/cabecalho.php");
include("conecta.php");
include("produtoDAO.php");

$produtos = listaProdutos($conexao);
if(array_key_exists("removido", $_GET) && $_GET['removido']=='true') :
	?>
<p class="alert alert-success">Produto removido com sucesso!</p>
<?php endif ?>
<table class="table table-striped table-bordered">
	<?php 
	foreach ($produtos as $produto) :
		?>
	<tr>
		<td><?=$produto['nome']?></td>
		<td><?=$produto['preco']?></td>
		<td><?=substr($produto['descricao'], 0, 40)?></td>
		<td><?=$produto['categoria_nome']?></td>
		<td>
			<a class="btn btn-primary" href="altera-produto-form.php?idProduto=<?=$produto['id']?>">Alterar</a>
		</td>
		<td>
			<form action="remove-produto.php" method="POST">
				<input type="hidden" name="id" value="<?=$produto['id']?>">
				<button class="btn btn-danger">Remover</button>
			</form>
		</td>
	</tr>
	<?php
	endforeach
	?>
</table>

<?php include 'estrutura/rodape.php';?>