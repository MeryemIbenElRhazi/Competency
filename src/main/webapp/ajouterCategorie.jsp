<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="ma.ac.esi.referentielCompetences.model.Categorie"%>

<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ajouter une catégorie de compétence</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Autres styles CSS -->
</head>
<body>
	<div class="container">
		<h2>Ajouter une catégorie de compétence</h2>
		<form action="AjouterCategorieServlet" method="POST">
			<div class="form-group">
				<label for="nom">Nom de la catégorie:</label> <input type="text"
					class="form-control" id="nom" name="nom" required>
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
	<div class="mt-5">
		<h3>Liste des catégories de compétences</h3>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Identifiant</th>
					<th>Nom</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
if (categories != null) {
    for (Categorie categorie : categories) {
%>
				<tr>
					<td><%= categorie.getIdCategorie() %></td>
					<td><%= categorie.getNom() %></td>
					<td>
						<div class="d-flex">
							<a style="margin-right: 10px;"
								href="editCategoriejsp.jsp?id=<%=categorie.getIdCategorie()%>"
								class="btn btn-primary btn-sm" role="button"
								onclick="return confirm('Êtes-vous sûr de vouloir éditer cette compétence ?');">
								<i class="fas fa-edit"></i> Éditer
							</a> <a href="DeleteCategorieServlet?id=<%=categorie.getIdCategorie()%>"
								class="btn btn-danger btn-sm" role="button"
								onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette compétence ?');">
								<i class="fas fa-trash-alt"></i> Supprimer
							</a>

						</div>
					</td>
				</tr>

				<%
    }
} else {
%>
				<tr>
					<td colspan="2">Aucune catégorie disponible.</td>
				</tr>
				<%
}
%>

			</tbody>
		</table>
	</div>
</body>
</html>
