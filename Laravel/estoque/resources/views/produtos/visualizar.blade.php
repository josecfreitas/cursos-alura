@extends("/estrutura/layout")

@section("main")
    <h1>Visualizar produto {{$produto->nome}} </h1>
    
    <ul>
        <li>
            <b>Valor:</b> R$ {{$produto->valor}} 
        </li>
        <li>
            <b>Descrição:</b> {{$produto->descricao}} 
        </li>
        <li>
            <b>Quantidade em estoque:</b> {{$produto->quantidade}}
        </li>
    </ul>

    <a href="/produtos" class="btn btn-default">Voltar</a>
@stop