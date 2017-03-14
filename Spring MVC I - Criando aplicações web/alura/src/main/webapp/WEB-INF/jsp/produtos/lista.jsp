<%-- 
    Autor(es): Jose Carlos de Freitas
    Data: 07/03/2017 às 06:55:51
    Arquivo: lista
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    </head>
    <body>
        <h1>Produtos</h1>

        ${msg}
        <table>
            <thead>
            <th>Título</th>
            <th>Descrição</th>
            <th>Páginas</th>
        </thead>

        <c:forEach items="${produtos }" var="produto">
            <tr>
                <td>
                    <a href="${s:mvcUrl('PC#detalheProduto').arg(0, produto.id).build()}">
                        ${produto.titulo}
                    </a>
                </td>
                <td>${produto.descricao }</td>
                <td>${produto.paginas }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>