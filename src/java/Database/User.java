package Database;

//Imports
import java.sql.SQLException;

//Begin Class User
public class User extends BaseDBFunctions{        
        
    //Checks database to see if username exists
    public boolean userNameExists(String userName) {
        boolean isValid = true;        
        try {                        
            this.stmt = this.con.createStatement();
            String sql = "select * from UserInfo"; //change tablename as needed
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if(rs.getString("UserName") == userName){
                    isValid = false;
                }                
            }            
            return isValid;            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }
    
   //Inserts new user information into database 
   public void newUser(String email, String userName, String pw){
       if(userNameExists(userName) == false){
           try {
               stmt.executeUpdate("insert into users(Email,UserName,Password)"
                       + "values('"+userName+"','"+email+"','"+pw+"')");
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
       else{
           //Output error message to login/signup html page
       }       
   } 
   
   //Logs user into site
    public boolean logIn(String userName, String pw){
       boolean loggedIn = false; 
       if(userNameExists(userName) == true){
           try {
               String sql = ("select Password from UserInfo where UserName="
                       + "'"+userName+"'");
               stmt.executeQuery(sql);
               if(rs.getString("Password").equals(pw)){ //double check logic for this
                   loggedIn = true;
               }               
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
       else{
           //Output error message to login/signup html page
       }
       return loggedIn;
   } 
    
   //Changes user's password 
   public void changePassword(String userName, String oldPW, String newPW){
       try {
               String sql = ("select Password from UserInfo where UserName="
                       + "'"+userName+"'");
               stmt.executeQuery(sql);
               if(rs.getString("Password").equals(oldPW)){ //double check logic for this
                   sql="Update UserInfo set Password=? where UserName="+userName;
                   ps = con.prepareStatement(sql);
                   ps.setString(1, newPW);
               }               
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
               //Output incorrect password/username message
           }
   }
   
} //End Class User