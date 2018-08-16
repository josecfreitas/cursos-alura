@extends('/estrutura/layout')

@section('main')
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
                <label for="descricao">Descrição</label>
                <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Digite a descrição">
            </div>
            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="text" class="form-control" id="quantidade" name="quantidade" placeholder="Digite a quantidade">
            </div>
            <button type="submit" class="btn btn-primary">Salvar produto</button>
        </form>
    </div>
@stop