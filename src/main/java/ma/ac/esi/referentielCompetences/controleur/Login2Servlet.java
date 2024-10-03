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
public class Login2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login2Servlet() {
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
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        
        
        ConnectBd connectBd = new ConnectBd();
        
        boolean success2=connectBd.AddUser(nom,prenom,email, psswd);
       
        if (success2 ) {
        	request.setAttribute("message", "Inscripropn réussi !");
        } else {
        	request.setAttribute("message", "Les information saisie sont incorrect , veuillez ressayer.");
        }
        
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
        
        
        
    }

   

		// TODO Auto-generated method stub
		
	}