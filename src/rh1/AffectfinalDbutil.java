package rh1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class AffectfinalDbutil {
	
	
	private static DataSource dataSource;
	
	public AffectfinalDbutil(DataSource theDataSource) {
		dataSource = theDataSource;
		
	}
	

	public void addaffect(affect affectation) throws Exception{
		
		int affectationid ;
		String affectationemail;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		forms_list tempform= new forms_list(1,"1","1","1","1","1","1","1","1","1","1","1");
		
		try {
			
			try {
				affectationid = Integer.parseInt(affectation.getId());
				affectationemail = affectation.getEmail();
				
				
				myConn = dataSource.getConnection();
				
				//create a sql statement
			
				String sql = "select * from forms where id = ?";
				myStmt = myConn.prepareStatement(sql);
				
				myStmt.setInt(1, affectationid);
				//execute query
				
				myRs = myStmt.executeQuery();
				//process result set
				
				while(myRs.next()) {
					//retrieve data from result set row
					
					int id1 = myRs.getInt("id");
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
					
					tempform = new forms_list(id1,title,question1,question2,
							question3, question4,question5,question6,question7,
							question8,question9,question10);
				}
			}
				
				finally {
					close(myConn, myStmt, myRs);
				}
			
			myConn = dataSource.getConnection();
			
			String sql1 = "insert into affect(idform,email,title,question1,question2,question3,question4,question5,question6,question7,question8,question9,question10) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql1);
			
			myStmt.setInt(1, affectationid);
			myStmt.setString(2, affectationemail);
			myStmt.setString(3, tempform.getTitle());
			myStmt.setString(4, tempform.getQuestion1());
			myStmt.setString(5, tempform.getQuestion2());
			myStmt.setString(6, tempform.getQuestion3());
			myStmt.setString(7, tempform.getQuestion4());
			myStmt.setString(8, tempform.getQuestion5());
			myStmt.setString(9, tempform.getQuestion6());
			myStmt.setString(10, tempform.getQuestion7());
			myStmt.setString(11, tempform.getQuestion8());
			myStmt.setString(12, tempform.getQuestion9());
			myStmt.setString(13, tempform.getQuestion10());
			
			myStmt.execute();	
		}
		
		finally {
			close(myConn, myStmt, null);
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