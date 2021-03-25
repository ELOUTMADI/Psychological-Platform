package rh1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class AffectfinalServlet
 */
@WebServlet("/AffectfinalServlet")
public class AffectfinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AffectfinalDbutil affectdbutil;
	private FormulaireDbutil formdbutil;
	
	@Resource(name="jdbc/inscrit")
	
	private DataSource dataSource;
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our user db util ... and pass in the conn pool / datasource
		
		try {
			
			affectdbutil = new AffectfinalDbutil(dataSource);
			formdbutil = new FormulaireDbutil(dataSource);
			
		}
		
		catch (Exception exc){
			throw new ServletException(exc);
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String thecommand = request.getParameter("command");
			
			if(thecommand == null) {
				thecommand = "random";
			}
			
			switch (thecommand) {
			
			case "chosen" :
				Affect(request, response);
				break;
			case "random" :
				randAffect(request, response);
				break;
			default :
				Affect(request, response);
			
			}
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
		
	}

	private void randAffect(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String email = request. getParameter("email");
		List<forms_list> forms = formdbutil.getform();
		Random rnd = new Random();
		int rand = rnd.nextInt(forms.size());
		int id = forms.get(rand).getId();
		Integer x = Integer.valueOf(id);
		String strid = x.toString();
		
		affect affectation= new affect(strid,email);
		affectdbutil.addaffect(affectation);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessAffect.html");
		dispatcher.forward(request, response);
		
		
	}

	private void Affect(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String email = request. getParameter("email");
		String id = request. getParameter("id");
		
		affect affectation= new affect(id,email);
		
		affectdbutil.addaffect(affectation);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessAffect.html");
		dispatcher.forward(request, response);
		}
}
