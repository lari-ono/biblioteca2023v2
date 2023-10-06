<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Gênero</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Editar Gênero</h1>
        <form action = "/autor/update" method="post">
            <input type="hidden" name="id" value ="${autor.id}">
            <div class= "form-group">
            <label form="nome"> Nome:</label>
            <input type="text" name="nome" class="form-control" value="${autor.nome}">

        </div>
        <br>
        
        <a href ="/autor/list" class ="btn btn-primary">Voltar</a>
        <button type="submit" class="btn btn-success">Salvar</button>
        </form>
        </div>
    </body>
</html>

