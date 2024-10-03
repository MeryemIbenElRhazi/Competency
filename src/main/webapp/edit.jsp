<%@page import="ma.ac.esi.referentielCompetences.model.Skill"%>
<%@page import="ma.ac.esi.referentielCompetences.model.SkillDAO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier une comp�tence</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Modifier une comp�tence</h2>
    
    <%-- R�cup�ration de l'identifiant de la comp�tence � modifier --%>
    <% String skillIdParam = request.getParameter("id");
       if (skillIdParam != null && !skillIdParam.isEmpty()) {
           int skillId = Integer.parseInt(skillIdParam);
           SkillDAO skillDAO = new SkillDAO();
           Skill skill = skillDAO.getSkillById(skillId);
           if (skill != null) { %>
           
           
               <form action="servlet" method="POST">
                   <input type="hidden" name="id" class="form-control" value="<%= skillIdParam %>"> 
               
                   <div class="form-group">
                       <label for="name">Nom de la comp�tence:</label>
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
                           <option value="">S�lectionnez un niveau</option>
                           <option value="D�butant" <%= skill.getLevel().equals("D�butant") ? "selected" : "" %>>D�butant</option>
                           <option value="Interm�diaire" <%= skill.getLevel().equals("Interm�diaire") ? "selected" : "" %>>Interm�diaire</option>
                           <option value="Avanc�" <%= skill.getLevel().equals("Avanc�") ? "selected" : "" %>>Avanc�</option>
                       </select>
                   </div>
                   <button type="submit" class="btn btn-primary">Modifier</button>
               </form>
           <% } else { %>
               <div class="alert alert-danger" role="alert">
                   La comp�tence avec l'identifiant <%= skillId %> n'existe pas.
               </div>
           <% }
       } else { %>
           <div class="alert alert-danger" role="alert">
               Identifiant de comp�tence manquant.
           </div>
       <% } %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>