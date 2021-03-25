package rh1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FormulaireDbutil {
	
	
	private DataSource dataSource;
	
	public FormulaireDbutil(DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public List<forms_list> getform() throws Exception {
		List<forms_list> form = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get a connection
			
			myConn = dataSource.getConnection();
		
			
			//create a sql statement
		
			String sql = "select * from forms order by id";
			
			myStmt = myConn.createStatement();
			
			//execute query
			
			myRs = myStmt.executeQuery(sql);
			//process result set
			
			while(myRs.next()) {
				//retrieve data from result set row
				
				int id = myRs.getInt("id");
				String title  = myRs.getString("title");
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
				
				forms_list tempform = new forms_list(id,title,question1,question2,
						question3, question4,question5,question6,question7,
						question8,question9,question10);
				//add it to the list of forms
				
				form.add(tempform);
			}
			
			
			
			return form;
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

