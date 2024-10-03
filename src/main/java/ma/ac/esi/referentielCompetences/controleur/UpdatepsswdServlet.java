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
public class UpdatepsswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdatepsswdServlet() {
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
        String psswd=request.getParameter("psswd");
        String psswd1=request.getParameter("psswd1");
        
        
        ConnectBd connectBd = new ConnectBd();
        
        boolean psswdUpdate= connectBd.Updatepsswd(psswd,psswd1,email);

        if (psswdUpdate) {
        	request.setAttribute("message", "Mots de Pass rénitialiser aveec succés !! ");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("message", "Les information saisie sont incompatible , veuillez ressayer.");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("psswdUpdate.jsp");
            dispatcher.forward(request, response);
        }
        
       
        
        
        
        
    }

   

		// TODO Auto-generated method stub
		
	}