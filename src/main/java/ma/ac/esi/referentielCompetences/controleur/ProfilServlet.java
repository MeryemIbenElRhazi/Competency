package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Profil;
import ma.ac.esi.referentielCompetences.model.ProfilDAO;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ProfilServlet
 */
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nom = request.getParameter("nom");
	    String competences = request.getParameter("competences");
	    String niveau = request.getParameter("niveau");
	    int salaire = Integer.parseInt(request.getParameter("salaire"));

	    Profil profil = new Profil(nom,competences,niveau,salaire);

	    ProfilDAO profilDAO = new ProfilDAO();
	    boolean succes = profilDAO.addProfil(profil);

	    if (succes) {
	        request.setAttribute("message", "Le profil a été ajouté avec succès.");
	        List<Profil> profils = profilDAO.getAllProfils();
			  request.setAttribute("items", profils);
	    } else {
	        request.setAttribute("erreur", "Erreur lors de l'ajout du profil.");
	    }

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin.jsp");
	    dispatcher.forward(request, response);
	}


}
