<?php

namespace estoque\Http\Controllers;

use estoque\Produto;
use Illuminate\Support\Facades\Request;
use estoque\Http\Requests\ProdutoRequest;
use estoque\Categoria;

class ProdutoController extends Controller
{
    // public function __construct()
    // {
    //     $this->middleware('auth');
    // }

    public function gerenciar()
    {
        $produtos = Produto::all();

        return view("produtos/gerenciar")
            ->with("produtos", $produtos);
    }

    public function visualizar($id)
    {
        $produto = Produto::find($id);

        if (is_null($produto)) abort(404);

        return view("produtos/visualizar")
            ->with("produto", $produto);
    }

    public function novo()
    {
        return view("produtos/novo")
            ->with("categorias", Categoria::all());
    }

    public function salvar(ProdutoRequest $request)
    {
        Produto::create($request->all());

        return redirect()
            ->action("ProdutoController@gerenciar")
            ->withInput(Request::only('nome'));
    }

    public function remover($id)
    {
        $produto = Produto::find($id);

        if (is_null($produto)) abort(404);

        $produto->delete();

        return redirect()
            ->action("ProdutoController@gerenciar");
    }
}
