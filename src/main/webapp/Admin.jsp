<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@page import="ma.ac.esi.referentielCompetences.model.ProfilDAO"%>
<%@ page import="ma.ac.esi.referentielCompetences.model.Profil"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ajouter un Profil</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
.container {
	margin-top: 20px;
}

#successAlert {
	position: fixed;
	top: 20%;
	left: 50%;
	transform: translateX(-50%);
	z-index: 1050;
	display: none; /* Cachée par défaut */
}
</style>
</head>
<body>
	<div class="container">
		<div class="alert alert-success" role="alert" id="successAlert"
			style="display: none;">
			<%
			if (request.getAttribute("message") != null) {
			%>
			<%=request.getAttribute("message")%>
			<%
			}
			%>
		</div>
		<h2>Ajouter un Profil</h2>
		<form action="ProfilServlet" method="POST">
			<div class="form-group">
				<label for="nom">Nom du profil</label> <input type="text"
					class="form-control" id="nom" name="nom" required>
			</div>
			<div class="form-group">
				<label for="competences">Les compétences</label>
				<textarea class="form-control" id="competences" name="competence"
					rows="2" required></textarea>
			</div>
			<div class="form-group">
				<label for="salaire">Salaire</label> <input type="text"
					class="form-control" id="salaire" name="salaire" required>
			</div>
			<div class="form-group">
				<label for="niveau">Niveau:</label> <select class="form-control"
					id="niveau" name="niveau" required>
					<option value="">Selectionnez un niveau</option>
					<option value="Debutant">Bac+3</option>
					<option value="Intermediaire">Bac+5</option>
					<option value="Avance">Junior</option>
					<option value="Sénior">Sénior</option>
					
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
			
		</form>
	</div>
	<div class="container">
	
	<div class="mt-5">
		<h3>Liste des Profils</h3>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Nom</th>
					<th>Compétences</th>
					<th>Niveau</th>
					<th>Salaire</th>
					
				</tr>
			</thead>
			<tbody  >
					<%
					ProfilDAO profilDAO = new ProfilDAO();
	    List<Profil> profils = profilDAO.getAllProfils();
	    if (profils != null && !profils.isEmpty()) {
	        for (Profil profil : profils) {
	%>
	<tr>
	    <td><%= profil.getNom() %></td>
	    <td><%= profil.getCompetences() %></td>
	    <td><%= profil.getNiveau() %></td>
	    <td><%= profil.getSalaire() %></td>
	
	
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="5">Aucune compétence disponible.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<!-- Bouton pour rediriger vers le formulaire de filtrage -->
		
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {
	<%if (request.getAttribute("message") != null) {%>
		// Affiche l'alerte
			$('#successAlert').show();

			// Masque l'alerte après 2 secondes (2000 millisecondes)
			setTimeout(function() {
				$('#successAlert').fadeOut('slow');
			}, 2000); // 2 secondes
	<%}%>
		});
	</script>
</body>
</html>
