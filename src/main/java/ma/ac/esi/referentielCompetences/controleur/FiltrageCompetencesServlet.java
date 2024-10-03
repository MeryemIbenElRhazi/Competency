package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

public class FiltrageCompetencesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SkillDAO skillDAO; // Déclaration de SkillDAO

    public FiltrageCompetencesServlet() {
        super();
        skillDAO = new SkillDAO(); // Instanciation de SkillDAO dans le constructeur
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres de filtrage
        String domaine = request.getParameter("domain");
        String niveau = request.getParameter("level");

        // Vérifier si les paramètres sont vides
        if (domaine == null || domaine.isEmpty()) {
            domaine = null; // ou toute valeur par défaut que vous souhaitez utiliser
        }
        if (niveau == null || niveau.isEmpty()) {
            niveau = null; // ou toute valeur par défaut que vous souhaitez utiliser
        }
        List<Skill> competences = skillDAO.filtrer(domaine, niveau);
        request.setAttribute("competences", competences);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeCompetences.jsp");
		dispatcher.forward(request, response);    }
}
