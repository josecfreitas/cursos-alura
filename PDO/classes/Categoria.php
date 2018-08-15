<?php

require_once "global.php";

class Categoria
{

    public $id;
    public $nome;

    public function __construct($id = false)
    {
        if (is_numeric($id)) {
            try {
                $this->id = $id;
                $this->carregar();
            } catch (Exception $e) {
                new MessageException($e);
            }
        }
    }

    public function listar()
    {
        $query = "SELECT id, nome FROM categorias";
        $conexao = Conexao::getInstance();
        $resultado = $conexao->query($query);
        $lista = $resultado->fetchAll();
        return $lista;
    }

    private function carregar()
    {
        if (!$this->id) {
            return $this;
        }

        $query = "SELECT id, nome FROM categorias WHERE id = $this->id";
        $conexao = Conexao::getInstance();
        $resultado = $conexao->query($query);
        $lista = $resultado->fetchAll();

        foreach ($lista as $linha) {
            $this->nome = $linha['nome'];

            return $this;
        }
    }

    public function inserir()
    {
        $query = "INSERT INTO categorias (nome) VALUES ('$this->nome');";
        $conexao = Conexao::getInstance();
        $conexao->exec($query);
    }

    public function atualizar()
    {
        $query = "UPDATE categorias set nome = '$this->nome' where id = $this->id";
        $conexao = Conexao::getInstance();
        $conexao->exec($query);
    }

    public function excluir()
    {
        $query = "DELETE FROM categorias where id = $this->id";
        $conexao = Conexao::getInstance();
        $conexao->exec($query);
    }
}
