@extends('/estrutura/layout')

@section('main')
    <ul>
        @foreach ($errors->all() as $error)
            <li>{{ $error }}</li>
        @endforeach
    </ul>

    <div class="container-fluid">
        <h1>Cadastrar novo produto</h1>
        <form method="post">
            <input type="hidden" name="_token" value="{{csrf_token()}}">

            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o nome">
            </div>
            <div class="form-group">
                <label for="valor">Valor</label>
                <input type="text" class="form-control" id="valor" name="valor" placeholder="Digite o valor">
            </div>
            <div class="form-group">
                <label for="categoria">Categoria</label>
                <select class="form-control" id="categoria" name="categoria_id">
                    <option value="" disabled selected>Selecione uma categoria</option>
                    @foreach ($categorias as $categoria)
                        <option value="{{ $categoria->id }}">{{ $categoria->nome }}</option>
                    @endforeach
                </select>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Digite a descrição">
            </div>
            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="text" class="form-control" id="quantidade" name="quantidade" placeholder="Digite a quantidade">
            </div>
            <div class="form-group">
                <label for="tamanho">Tamanho</label>
                <input type="text" class="form-control" id="tamanho" name="tamanho" placeholder="Digite o tamanho">
            </div>
            <button type="submit" class="btn btn-primary">Salvar produto</button>
        </form>
    </div>
@stop