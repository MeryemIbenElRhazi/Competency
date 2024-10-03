<%@page import="ma.ac.esi.referentielCompetences.model.Skill"%>
<%@page import="ma.ac.esi.referentielCompetences.model.SkillDAO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier une compétence</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Modifier une compétence</h2>
    
    <%-- Récupération de l'identifiant de la compétence é modifier --%>
    <% String skillIdParam = request.getParameter("id");
       if (skillIdParam != null && !skillIdParam.isEmpty()) {
           int skillId = Integer.parseInt(skillIdParam);
           SkillDAO skillDAO = new SkillDAO();
           Skill skill = skillDAO.getSkillById(skillId);
           if (skill != null) { %>
           
           
               <form action="servlet" method="POST">
                   <input type="hidden" name="id" class="form-control" value="<%= skillIdParam %>"> 
               
                   <div class="form-group">
                       <label for="name">Nom de la compétence:</label>
                       <input type="text" class="form-control" id="name" name="name" value="<%= skill.getName() %>" required>
                   </div>
                   <div class="form-group">
                       <label for="description">Description:</label>
                       <textarea class="form-control" id="description" name="description" rows="3" required><%= skill.getDescription() %></textarea>
                   </div>
                   <div class="form-group">
                       <label for="domain">Domaine:</label>
                       <input type="text" class="form-control" id="domain" name="domain" value="<%= skill.getDomain() %>" required>
                   </div>
                   <div class="form-group">
                       <label for="level">Niveau:</label>
                       <select class="form-control" id="level" name="level" required>
                           <option value="">Sélectionnez un niveau</option>
                           <option value="Débutant" <%= skill.getLevel().equals("Débutant") ? "selected" : "" %>>Débutant</option>
                           <option value="Intermédiaire" <%= skill.getLevel().equals("Intermédiaire") ? "selected" : "" %>>Intermédiaire</option>
                           <option value="Avancé" <%= skill.getLevel().equals("Avancé") ? "selected" : "" %>>Avancé</option>
                       </select>
                   </div>
                   <button type="submit" class="btn btn-primary">Modifier</button>
               </form>
           <% } else { %>
               <div class="alert alert-danger" role="alert">
                   La compétence avec l'identifiant <%= skillId %> n'existe pas.
               </div>
           <% }
       } else { %>
           <div class="alert alert-danger" role="alert">
               Identifiant de compétence manquant.
           </div>
       <% } %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>