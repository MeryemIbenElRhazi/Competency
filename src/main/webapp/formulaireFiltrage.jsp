<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulaire de Filtrage</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h2>Filtrer la liste des compétences</h2>
        <form action="FiltrageCompetencesServlet" method="GET">
            <div class="form-group">
                <label for="domaine">Domaine:</label>
                <select name="domain" id="domain" class="form-control">
                   
                    <option value="Développement Web">Développement Web</option>
                    <option value="Deep Learning">Deep Learning</option>
                    <option value="Data Science">Data Science</option>
                    <option value="Statistique">Statistique</option>
                    <option value="Cybersécurité">Cybersécurité</option>
                    
                </select>
            </div>
            <div class="form-group">
                <label for="niveau">Niveau:</label>
                <select name="level" id="level" class="form-control">
                    
                    <option value="Débutant">Debutant</option>
                    <option value="Intermédiaire">Intermediaire</option>
                    <option value="Avancé">Avance</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Filtrer</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
