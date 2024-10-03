package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.ConnectBd;



import java.io.IOException;
import java.net.URLEncoder;


/**
 *  implementation class SkillServlet
 */
public class psswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public psswdServlet() {
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
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        
        
        ConnectBd connectBd = new ConnectBd();
        
        boolean psswdfind= connectBd.Findpsswd(email,nom,prenom);

        if (psswdfind ) {
        	request.setAttribute("message", "Coordonnés corrects, droit à la rénitialisation ");
        	response.sendRedirect("psswdUpdate.jsp?email=" + URLEncoder.encode(email, "UTF-8"));
        } else {
        	request.setAttribute("message", "Les information saisie sont incorrect , veuillez ressayer.");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("psswd.jsp");
            dispatcher.forward(request, response);
        }
        
       
        
        
        
        
    }

   

		// TODO Auto-generated method stub
		
	}