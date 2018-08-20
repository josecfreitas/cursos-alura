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

Route::get('/login', "LoginController@form");
Route::post('/login', "LoginController@login");

Route::get('/produtos', "ProdutoController@gerenciar");
Route::get('/produtos/novo', "ProdutoController@novo");
Route::post('/produtos/novo', "ProdutoController@salvar");
Route::get('/produtos/{id}', "ProdutoController@visualizar");
Route::get('/produtos/{id}/remover', "ProdutoController@remover");

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');
