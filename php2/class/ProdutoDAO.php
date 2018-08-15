<?php
class ProdutoDAO {

	private $conexao;

	function __construct($conexao){
		$this->conexao = $conexao;
	}

	function insereProduto(Produto $produto){
		$query = "insert into produtos (nome, preco, descricao, categoria_id, usado) values ('{$produto->getNome()}', {$produto->getPreco()}, '{$produto->getDescricao()}', {$produto->getCategoria()->getId()}, {$produto->isUsado()});";
		return mysqli_query($this->conexao, $query);
	}
	function alteraProduto(Produto $produto){
		$query = "update produtos set nome = '{$produto->getNome()}', preco = {$produto->getPreco()}, descricao = '{$produto->getDescricao()}', categoria_id = {$produto->getCategoria()->getId()}, usado = {$produto->isUsado()} where id = {$produto->getId()};";
		return mysqli_query($this->conexao, $query);
	}

	function listaProdutos(){
	// $produtos = array(); sintaxe antiga
		$produtos = [];

		$result = mysqli_query($this->conexao, "select p.*, c.id as categoria_id, c.nome as categoria_nome from produtos p join categorias c on p.categoria_id = c.id");
		while ($produto_array = mysqli_fetch_assoc($result)) {
			array_push($produtos, $this->produtoFromArray($produto_array));
		}

		return $produtos;
	}

	function buscaProduto($id){
		$result = mysqli_query($this->conexao, "select * from produtos where id = {$id}");
		return $this->produtoFromArray(mysqli_fetch_assoc($result));
	}

	function removeProduto($id) {
		$query = "delete from produtos where id = {$id}";
		return mysqli_query($this->conexao, $query);
	}

	function produtoFromArray($produto_array){
		$categoria = new Categoria();
		$categoria->setid($produto_array['categoria_id']);
		$categoria->setNome($produto_array['categoria_nome']);

		$nome = $produto_array['nome'];
		$preco = $produto_array['preco'];
		$descricao = $produto_array['descricao'];
		$usado = $produto_array['usado'];

		$produto = new Produto($nome, $preco, $descricao, $categoria, $usado);
		$produto->setId($produto_array['id']);

		return $produto;
	}

}