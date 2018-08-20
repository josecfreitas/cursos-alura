@extends('/estrutura/layout')

@section('main')
    <div class="container-fluid">
        <h1Login</h1>
        <form method="post">
            <input type="hidden" name="_token" value="{{csrf_token()}}">

            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu e-mail">
            </div>
            <div class="form-group">
                <label for="senha">Valor</label>
                <input type="password" class="form-control" id="senha" name="password" placeholder="Digite sua senha">
            </div>
            
            <button type="submit" class="btn btn-primary">Logar</button>
        </form>
    </div>
@stop