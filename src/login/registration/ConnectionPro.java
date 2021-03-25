package login.registration;


import java.sql.*;


public class ConnectionPro {
    private static Connection connect;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/inscrit?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","7Q2brDtsa8aO7FU");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return connect;
    }
}