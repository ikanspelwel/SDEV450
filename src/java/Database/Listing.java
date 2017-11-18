package Database;


//Imports
import java.sql.SQLException;
import java.sql.Statement;
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
    
    //Pulls listings in order
    public Objects.Listing inOrder(int id) throws SQLException {
        Objects.Listing listing = null;
        try{
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM 'LISTINGS' "
                    + "WHERE 'LISTING_ID' = ? ");
            /**
             * Safely add the id into the statement in replacement of the question mark
             */
           this.preparedStmt.setInt(1, id);
           /* Safely execute the statement */
           this.rs = this.preparedStmt.executeQuery();
           
           /* Returns true if a result was found, false if not */
           if (rs.next()) {
               
               /*Store everything in a new listing instince. */
               listing = new Objects.Listing(rs.getInt("LISTING_ID"), rs.getDouble("PRICE"),
                       rs.getInt("FK_UID"), rs.getDate("DATE_POSTED"), rs.getString("LISTING_TITLE"), 
                       rs.getString("DESCRIPTION"), rs.getString("CATEGORY"), rs.getString("EMAIL")
                       
                       );
           }
        } catch (SQLException e) {
            throw e;
        }
       
    
        return listing;
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