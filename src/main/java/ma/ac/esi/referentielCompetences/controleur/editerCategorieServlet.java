package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Categorie;
import ma.ac.esi.referentielCompetences.model.CategorieDAO;

import java.io.IOException;

public class editerCategorieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public editerCategorieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("name");
        String idEditer = request.getParameter("id");
        int id = Integer.parseInt(idEditer);

        Categorie categorie = new Categorie();
        categorie.setIdCategorie(id);
        categorie.setNom(nom);

        CategorieDAO categorieDAO = new CategorieDAO();
        boolean success = categorieDAO.editCategorie(categorie);

        if (success) {
            response.sendRedirect("ajouterCategorie.jsp"); // Redirection après édition
        } else {
            response.getWriter().println("Échec de l'édition de la catégorie.");
        }
    }
}
