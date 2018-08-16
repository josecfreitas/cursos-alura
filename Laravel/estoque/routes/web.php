<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return "teste";
});

Route::get('/produtos', "ProdutoController@gerenciar");
Route::get('/produtos/visualizar/{id}', "ProdutoController@visualizar");
Route::get('/produtos/novo', "ProdutoController@novo");
Route::post('/produtos/novo', "ProdutoController@salvar");
