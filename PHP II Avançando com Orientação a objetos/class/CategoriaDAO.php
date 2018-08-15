<?php

class CategoriaDAO {

	private $conexao;

	function __construct($conexao){
		$this->conexao = $conexao;
	}

	function listaCategorias(){
		$categorias = [];

		$result = mysqli_query($this->conexao, "select * from categorias");
		while ($categoria_array = mysqli_fetch_assoc($result)) {
			$categoria = new Categoria();

			$categoria->setId($categoria_array['id']);
			$categoria->setNome($categoria_array['nome']);

			array_push($categorias, $categoria);
		}

		return $categorias;
	}
}