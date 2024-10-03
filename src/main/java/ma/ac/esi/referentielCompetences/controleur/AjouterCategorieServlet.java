package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ma.ac.esi.referentielCompetences.model.Categorie;
import ma.ac.esi.referentielCompetences.model.CategorieDAO;


public class AjouterCategorieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AjouterCategorieServlet() {
        super();
    }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajouterCategorie.jsp");
        dispatcher.forward(request, response);
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomCategorie = request.getParameter("nom");
        Categorie nouvelleCategorie = new Categorie();
        CategorieDAO categorieDAO = new CategorieDAO();
        nouvelleCategorie.setNom(nomCategorie);
        boolean ajoutReussi = categorieDAO.ajouterCategorie(nouvelleCategorie);
        // Rediriger vers la page d'ajout de catégorie avec un message approprié
        if (ajoutReussi) {
            request.setAttribute("message", "Catégorie ajoutée avec succès !");
        } else {
            request.setAttribute("erreur", "Erreur lors de l'ajout de la catégorie.");
        }
        List<Categorie> categories = categorieDAO.getAllCategories();
		request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajouterCategorie.jsp");
        dispatcher.forward(request, response);
    }
}
