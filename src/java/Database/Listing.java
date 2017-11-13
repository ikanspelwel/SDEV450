package Database;


//Imports
import java.sql.SQLException;

//Begin Class User
public class Listing extends BaseDBFunctions{        
        
    //Checks listings based on search term
    public boolean search(String keyword) {
        boolean hasResults = false;
        try {                        
            this.stmt = this.con.createStatement();
            String sql = "select Title, Description from Listings"; //change tablename as needed            
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if(rs.getString("Title") == keyword || 
                        rs.getString("Description").contains(keyword)){ //double check syntax                         
                        String ID = rs.getString("ListingID");
                        sql = ("select * from Listings where ListingID="
                       + "'"+ID+"'"); //may be repetitve given previous line
                        stmt.executeQuery(sql);
                        hasResults = true;      
                }                
            }            
            return hasResults;            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }        
    
    
   //Inserts new user information into database 
   public void newListing(String Title, String Desc, Class Image,
           double Price){
           try {
               stmt.executeUpdate("insert into Listings(Title,Description,Image,Price)"
                       + "values('"+Title+"','"+Desc+"','"+Image+"','"+Price+"')");
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }              
   
   //Links to paypal to purchase item?
   public void buyListing(){
       }
   } //End Class User