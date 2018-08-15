<?php

class Conexao {

    public static function getInstance() {
        return new PDO('pgsql:host=127.0.0.1;dbname=pdo', 'postgres', 'bicrement');
    }
}