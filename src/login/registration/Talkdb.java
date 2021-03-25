package login.registration;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;




public class Talkdb {
	
private DataSource dataSource;
	
	public Talkdb(DataSource theDataSource) {
		dataSource = theDataSource;}

    
    public List<Questions> getquestions(String email) throws Exception {
		List<Questions> question = new ArrayList<Questions>();
		
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get a connection
			
			myConn = dataSource.getConnection();

		
			//create a sql statement
		
			String sql = "select * from affect ";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			
			//execute query
			
			myRs = myStmt.executeQuery(sql);
			//process result set
			
			while(myRs.next()) {
				//retrieve data from result set row
				
				int idaffect = myRs.getInt("idaffect");
				int idform = myRs.getInt("idform");
				String name  = myRs.getString("email");
				String title = myRs.getString("title");
				String question1 = myRs.getString("question1");
				String question2 = myRs.getString("question2");
				String question3 = myRs.getString("question3");
				String question4 = myRs.getString("question4");
				String question5 = myRs.getString("question5");
				String question6 = myRs.getString("question6");
				String question7 = myRs.getString("question7");
				String question8 = myRs.getString("question8");
				String question9 = myRs.getString("question9");
				String question10 = myRs.getString("question10");
				
				//create new user object
				
				Questions tempquestions = new Questions(idaffect,idform,name,title,question1,question2,
						question3, question4,question5,question6,question7,
						question8,question9,question10);
				//add it to the list of forms
				
				if ( name.equals(email))
					question.add(tempquestions);
				
			}
			
			
			
			return question;
		}
		finally {
			//close JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}		
	}		

 }