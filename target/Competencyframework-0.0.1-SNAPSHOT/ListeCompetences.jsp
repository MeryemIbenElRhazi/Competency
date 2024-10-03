<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="ma.ac.esi.referentielCompetences.model.Skill"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des compétences</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Autres styles CSS -->
</head>
<body>
    <div class="container">
        <h2>Liste des compétences</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Domaine</th>
                    <th>Niveau</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Skill> skills = (List<Skill>) request.getAttribute("competences");
                if (skills != null && !skills.isEmpty()) {
                    for (Skill skill : skills) {
                %>
                <tr>
                    <td><%= skill.getName() %></td>
                    <td><%= skill.getDescription() %></td>
                    <td><%= skill.getDomain() %></td>
                    <td><%= skill.getLevel() %></td>
                </tr>
                <% 
                    }
                } else {
                %>
                <tr>
                    <td colspan="4">Aucune compétence disponible.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
