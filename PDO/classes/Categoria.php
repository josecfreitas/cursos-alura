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

        $query = "SELECT id, nome FROM categorias WHERE id = :id";

        $conexao = Conexao::getInstance();

        $stmt = $conexao->prepare($query);
        $stmt->bindValue(':id', $this->id);
        $stmt->execute();
        $row = $stmt->fetchObject();

        $this->nome = $row->nome;

        return $this;
    }

    public function inserir()
    {
        $query = "INSERT INTO categorias (nome) VALUES (:nome);";
        $conexao = Conexao::getInstance();
        $stmt = $conexao->prepare($query);
        $stmt->bindValue(':nome', $this->nome);
        $stmt->execute();
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
