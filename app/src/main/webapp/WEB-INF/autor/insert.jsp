<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Novo Autor</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Novo Autor</h1>
        <form action="/autor/insert"  method="post">
        <div class="form-group">
            <label for="nome"> Nome: </label>
            <input type="text" name="nome" class="form-control"/>

        </div>
        <br/>
        
                        <a href ="/autor/list" class ="btn btn-primary">Voltar</a>
                        <button type="submit" class="btn btn-success">Salvar</button>
    </form>
    </div>
    </body>
</html>

