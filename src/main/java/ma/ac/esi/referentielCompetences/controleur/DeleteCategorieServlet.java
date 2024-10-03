package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.CategorieDAO;

@WebServlet("/deleteCategorie")
public class DeleteCategorieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteCategorieServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'identifiant de la catégorie à supprimer depuis les paramètres de requête
        String categorieIdParam = request.getParameter("id");
        if (categorieIdParam != null && !categorieIdParam.isEmpty()) {
            int categorieId = Integer.parseInt(categorieIdParam);

            // Supprimer la catégorie en utilisant le DAO approprié
            CategorieDAO categorieDAO = new CategorieDAO();
            boolean success = categorieDAO.deleteCategorie(categorieId);

            if (success) {
                request.setAttribute("message", "La catégorie a été supprimée avec succès.");
            } else {
                request.setAttribute("erreur", "Erreur lors de la suppression de la catégorie.");
            }
        } else {
            request.setAttribute("erreur", "L'identifiant de la catégorie à supprimer n'a pas été spécifié.");
        }

        // Rediriger vers la page appropriée après la suppression
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouterCategorie.jsp");
        dispatcher.forward(request, response);
    }
}

