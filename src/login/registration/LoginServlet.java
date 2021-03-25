package login.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import login.registration.Questions;

import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }
    
    private Talkdb talkdb;
	
	@Resource(name="jdbc/inscrit")
	
	private DataSource dataSource;
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our user db util ... and pass in the conn pool / datasource
		
		try {
			
			talkdb = new Talkdb(dataSource);
			
		}
		
		catch (Exception exc){
			throw new ServletException(exc);
			
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
	}	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		PrintWriter out = response.getWriter();
        String loggingemail = request.getParameter("email");
        String loggingpass = request.getParameter("password");
        String loggingrole = request.getParameter("role");
        
        UserDataBase db =  new UserDataBase(ConnectionPro.getConnection());
        User user = db.loggingUser(loggingemail, loggingpass, loggingrole);

        
        if(user!=null && user.getRole().equals("RH")){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
                response.sendRedirect("list-users.jsp");
                
        }else if(user!=null && user.getRole().equals("Psychologue")){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
                response.sendRedirect("psy.html");
                
        }else if(user!=null && user.getRole().equals("Utilisateur")){
    		java.util.List<Questions> question = new ArrayList<Questions>();
    		try {
    			question = talkdb.getquestions(loggingemail);
    			request.setAttribute("Questions", question);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
			session.setAttribute("Questions", question);
                response.sendRedirect("final.jsp");
                
        }
        
        
        else{
			
			out.println("user not found");
        }

		
		
		
		doGet(request, response);
	}

}
