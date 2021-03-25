package login.registration;
import java.sql.*;

public class UserDataBase {
    Connection connect ;

    public UserDataBase(Connection connect) {
        this.connect = connect;
    }
    
    //register
    public boolean saveUser(User user){
        boolean val = false;
        try{
            String query = "insert into user(name,email,password,role) values(?,?,?,?)";
           
           PreparedStatement bd = this.connect.prepareStatement(query);
           bd.setString(1, user.getName());
           bd.setString(2, user.getEmail());
           bd.setString(3, user.getPassword());
           bd.setString(4,user.getRole());
           bd.executeUpdate();
           
           val = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return val;
    }
    
    
  //login
    public User loggingUser(String email, String pass, String role){
        User usr=null;
        try{
            String query ="select * from user where email=? and password=? and role=?";
            PreparedStatement pst = this.connect.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            pst.setString(3, role);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setName(rs.getString("name"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                usr.setRole(rs.getString("role"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
}
}
