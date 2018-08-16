<?php

namespace estoque\Http\Controllers;

use DB;
use Request;

class ProdutoController extends Controller
{

    public function gerenciar()
    {
        $produtos = DB::select("SELECT * FROM produtos");

        return view("produtos/gerenciar")
            ->with("produtos", $produtos);
    }

    public function visualizar()
    {
        $id = Request::route('id');
        $produto = DB::select("SELECT * FROM produtos WHERE id = ?", [$id]);

        if (empty($produto)) abort(404);

        return view("produtos/visualizar")
            ->with("produto", $produto[0]);
    }

    public function novo()
    {
        return view("produtos/novo");
    }

    public function salvar()
    {
        $nome = Request::input("nome");
        $valor = Request::input("valor");
        $descricao = Request::input("descricao");
        $quantidade = Request::input("quantidade");

        DB::insert(
            "INSERT INTO produtos (nome, valor, descricao, quantidade) VALUES (?, ?, ?, ?)",
            array($nome, $valor, $descricao, $quantidade)
        );

        return redirect()
            ->action("ProdutoController@gerenciar")
            ->withInput(Request::only('nome'));
    }
}
