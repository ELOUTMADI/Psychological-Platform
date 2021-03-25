package com.userlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {
	
	
	private DataSource dataSource;
	
	public UserDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public List<Userlist_rh> getUsers() throws Exception {
		List<Userlist_rh> users = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//get a connection
			
			myConn = dataSource.getConnection();
		
			
			//create a sql statement
		
			String sql = "select * from user where role='Utilisateur' order by name";
			
			myStmt = myConn.createStatement();
			
			//execute query
			
			myRs = myStmt.executeQuery(sql);
			//process result set
			
			while(myRs.next()) {
				//retrieve data from result set row
				
				String name  = myRs.getString("name");
				String email = myRs.getString("email");
				String role = myRs.getString("role");
				
				//create new user object
				
				Userlist_rh tempUser = new Userlist_rh(name, email,role);
				
				//add it to the list of users
				
				users.add(tempUser);
			}
			
			
			
			return users;
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

