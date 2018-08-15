<?php

require_once("classes/Conexao.php");

class Categoria
{

    public $id;
    public $nome;

    public function listar()
    {
        $query = "SELECT id, nome FROM categorias";
        $conexao = Conexao::getInstance();
        $resultado = $conexao->query($query);
        $lista = $resultado->fetchAll();
        return $lista;
    }

    public function inserir() {
        $query = "INSERT INTO categorias (nome) VALUES ('$this->nome');";
        $conexao = Conexao::getInstance();
        $conexao->exec($query);
    }
}