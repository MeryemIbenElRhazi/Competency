package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;

@WebServlet("/UpdateSkillServlet")
public class servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int skillId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String domain = request.getParameter("domain");
        String level = request.getParameter("level");

        // Créer un objet Skill avec les nouvelles valeurs
        Skill updatedSkill = new Skill(name, description, domain, level);
        updatedSkill.setId(skillId); // Assurez-vous que l'identifiant est défini pour la mise à jour

        // Mettre à jour la compétence en utilisant le DAO approprié
        SkillDAO skillDAO = new SkillDAO();
        boolean success = skillDAO.updateSkill(updatedSkill);

        if (success) {
            response.sendRedirect("SkillCrud.jsp"); // Redirection après édition
        } else {
            
            response.getWriter().println("Échec de l'édition de la compétence.");
        }

 
    }

}