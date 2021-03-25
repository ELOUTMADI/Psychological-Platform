package rh1;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/FormAffectServlet")
public class FormAffectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private FormulaireDbutil formdbutil;
	
	@Resource(name="jdbc/inscrit")
	
	private DataSource dataSource;
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our user db util ... and pass in the conn pool / datasource
		
		try {
			
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
		//list the forms ... in MVC fashion
		try {
			
			listforms(request, response);
		
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void listforms(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		// get users from db util
		
	
		List<forms_list> forms = formdbutil.getform();
		//add users to the request
		
		request.setAttribute("Forms_List", forms);
		
		// send to JSP page (view)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/affecter-form.jsp");
		dispatcher.forward(request, response);
		
	}

}
