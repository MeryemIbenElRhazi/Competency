package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;

@WebServlet("/deleteSkill")
public class DeleteSkillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteSkillServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'identifiant de la compétence à supprimer depuis les paramètres de requête
        String skillIdParam = request.getParameter("id");
        if (skillIdParam != null && !skillIdParam.isEmpty()) {
            int skillId = Integer.parseInt(skillIdParam);

            // Supprimer la compétence en utilisant le DAO approprié
            SkillDAO skillDAO = new SkillDAO();
            boolean success = skillDAO.deleteskill(skillId);

            if (success) {
                request.setAttribute("message", "La compétence a été supprimée avec succès.");
            } else {
                request.setAttribute("erreur", "Erreur lors de la suppression de la compétence.");
            }
        } else {
            request.setAttribute("erreur", "L'identifiant de la compétence à supprimer n'a pas été spécifié.");
        }

        // Rediriger vers la page appropriée après la suppression
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // La suppression sera gérée via la méthode GET, donc cette méthode ne sera pas utilisée ici
        doGet(request, response);
    }
}
