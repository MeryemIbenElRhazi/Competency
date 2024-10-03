package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.ConnectBd;


import java.io.IOException;


/**
 *  implementation class SkillServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String psswd = request.getParameter("psswd");
        
        ConnectBd connectBd = new ConnectBd();
        
        boolean success = connectBd.FindUser(email, psswd);
        boolean success2 = connectBd.FindAdmin(email, psswd);

        if (success2) {
        	request.setAttribute("message", "Bienvenue ADMIN");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
            dispatcher.forward(request, response);
            
        } else if (success) {
        	request.setAttribute("message", "Connexion réussie");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SkillCrud.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Les informations saisies sont incorrectes, veuillez réessayer.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
    }


   

		// TODO Auto-generated method stub
		
	}