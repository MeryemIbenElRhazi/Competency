<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Éditer une catégorie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Éditer une catégorie</h2>
        <form action="editerCategorieServlet" method="POST">
            <div class="form-group">
                <label for="id">ID de la catégorie:</label>
                <input type="text" class="form-control" id="id" name="id" value="${categorie.idCategorie}" required>
            </div>
            <div class="form-group"> 
                <label for="name">Nom de la catégorie:</label>
                <input type="text" class="form-control" id="name" name="name" value="${categorie.nom}" required>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
    </div>
</body>
</html>
