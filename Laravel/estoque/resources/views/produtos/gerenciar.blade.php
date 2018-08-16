@extends("/estrutura/layout")

@section("main")
    <h1>Gerenciar produtos</h1>

    @if (old('nome'))
        <p class="alert alert-success">Produto {{ old('nome') }} inserido com sucesso!</p>
    @endif

    <table class="table">

        <thead>
            <th></th>
            <th>Nome</th>
            <th>Valor</th>
            <th>Descrição</th>
            <th>Quantidade</th>
        </thead>

        <tbody>
            @forelse ($produtos as $produto)
                <tr class="{{$produto->quantidade < 3 ? 'table-danger' : ''}}">
                    <td><a href="{{ action('ProdutoController@visualizar', array('id' => $produto->id)) }}"><i class="fas fa-search"></i></a></td>
                    <td>{{$produto->nome}}</td>
                    <td>{{$produto->valor}}</td>
                    <td>{{$produto->descricao or "Sem descrição"}}</td>
                    <td>{{$produto->quantidade}}</td>
                </tr>
            @empty
                <tr>
                    <td colspan="5" class="text-center">Nenhum produto cadastrado</td>
                </tr>
            @endforelse
        </tbody>
        
    </table>
    
    <a href="{{ action('ProdutoController@novo') }}">Novo</a>
@stop