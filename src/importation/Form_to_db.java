package importation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Form_to_db extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10 = null;
	public static final String CHAMP_PATH0= "name";
	public static final String CHAMP_PATH1= "Question1";
	public static final String CHAMP_PATH2= "Question2";
	public static final String CHAMP_PATH3= "Question3";
	public static final String CHAMP_PATH4= "Question4";
	public static final String CHAMP_PATH5= "Question5";
	public static final String CHAMP_PATH6= "Question6";
	public static final String CHAMP_PATH7= "Question7";
	public static final String CHAMP_PATH8= "Question8";
	public static final String CHAMP_PATH9= "Question9";
	public static final String CHAMP_PATH10= "Question10";
	public void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException{
		c0 = request.getParameter(CHAMP_PATH0);
		c1 = request.getParameter(CHAMP_PATH1);
		c2 = request.getParameter(CHAMP_PATH2);
		c3 = request.getParameter(CHAMP_PATH3);
		c4 = request.getParameter(CHAMP_PATH4);
		c5 = request.getParameter(CHAMP_PATH5);
		c6 = request.getParameter(CHAMP_PATH6);
		c7 = request.getParameter(CHAMP_PATH7);
		c8 = request.getParameter(CHAMP_PATH8);
		c9 = request.getParameter(CHAMP_PATH9);
		c10 = request.getParameter(CHAMP_PATH10);
		Connection connect = null;
		Statement statement = null;
		PreparedStatement  preparedStatement = null;
		ResultSet resultSet = null;
		try {
		
			java.util.List<String> k = Arrays.asList(c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
		    
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
