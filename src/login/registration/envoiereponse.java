package login.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class envoiereponse
 */
@WebServlet("/envoiereponse")
public class envoiereponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public envoiereponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] reponse = request.getParameterValues("reponse");
		
		reponse reponseModel = new reponse(reponse[0],reponse[1],reponse[2],reponse[3],reponse[4],reponse[5],reponse[6],reponse[7],reponse[8],reponse[9],reponse[10]);


		
		envoie add = new envoie(ConnectionPro.getConnection());
		
		try {
			add.addreponse(reponseModel);
			   response.sendRedirect("Successresponse.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
