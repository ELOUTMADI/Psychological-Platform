package login.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class envoie
 */
@WebServlet("/envoie")
public class envoie extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection connect ;

    public envoie(Connection connect) {
        this.connect = connect;
    }
    
    
    public boolean addreponse( reponse reponse) throws Exception{
        boolean val = false;
		

		try {
			
			String sql1 = "insert into reponse values (default,?,?,?,?,?,?,?,?,?,?,?)";
			
	        PreparedStatement myStmt = this.connect.prepareStatement(sql1);
			
			myStmt.setString(1, reponse.getTitle());
			myStmt.setString(2, reponse.getReponse1());
			myStmt.setString(3, reponse.getReponse2());
			myStmt.setString(4, reponse.getReponse3());
			myStmt.setString(5, reponse.getReponse4());
			myStmt.setString(6,reponse.getReponse5());
			myStmt.setString(7, reponse.getReponse6());
			myStmt.setString(8, reponse.getReponse7());
			myStmt.setString(9, reponse.getReponse8());
			myStmt.setString(10, reponse.getReponse9());
			myStmt.setString(11, reponse.getReponse10());
			
			myStmt.execute();	
			val = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return val;
    }
		}
	


