package com.userlist;

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
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDbUtil userdbutil;
	
	@Resource(name="jdbc/inscrit")
	
	private DataSource dataSource;
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our user db util ... and pass in the conn pool / datasource
		
		try {
			
			userdbutil = new UserDbUtil(dataSource);
			
		}
		
		catch (Exception exc){
			throw new ServletException(exc);
			
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list the users ... in MVC fashion
		try {
			
			
			listUsers(request, response);
			
		
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}


	private void listUsers(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		// get users from db util
		
	
		List<Userlist_rh> users = userdbutil.getUsers();
		//add students to the request
		
		request.setAttribute("Users_List", users);
		
		// send to JSP page (view)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
		dispatcher.forward(request, response);
		
	}

}
