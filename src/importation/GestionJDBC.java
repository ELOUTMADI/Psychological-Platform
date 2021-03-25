package importation;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class GestionJDBC extends HttpServlet{
	private String c = null;
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_PATH= "path";
	public void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException{
		c = request.getParameter(CHAMP_PATH);
		
		Connection connect = null;
		Statement statement = null;
		PreparedStatement  preparedStatement = null;
		ResultSet resultSet = null;
		try {
		Impocsv e = new Impocsv(c);
		ArrayList<String> k = e.impocsv();
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/inscrit?user=root&password=7Q2brDtsa8aO7FU&serverTimezone=UTC");
			
			preparedStatement = connect.prepareStatement("INSERT INTO forms VALUES (default,?,?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, k.get(0));
			preparedStatement.setString(2, k.get(1));
			preparedStatement.setString(3, k.get(2));
			preparedStatement.setString(4, k.get(3));
			preparedStatement.setString(5, k.get(4));
			preparedStatement.setString(6, k.get(5));
			preparedStatement.setString(7, k.get(6));
			preparedStatement.setString(8, k.get(7));
			preparedStatement.setString(9, k.get(8));
			preparedStatement.setString(10, k.get(9));
			preparedStatement.setString(11, k.get(10));
			System.out.println("Succeed");
			
			preparedStatement.addBatch();
			preparedStatement.executeUpdate();
			
			this.getServletContext().getRequestDispatcher( "/Success.html" ).forward( request, response );
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
  
} 