package Database;


//Imports
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import Objects.Listing;
//Begin Class User
public class ListingDB extends BaseDBFunctions{        
        
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
    public ArrayList<Listing> inOrder(int low, int high) throws SQLException {
        ArrayList<Listing> arrListing = new ArrayList<>();
        Objects.Listing listing = null;
        try{
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `LISTINGS` "
                    + "ORDER BY `LISTING_ID` DESC "
                    + "LIMIT ?, ?");
            /**
             * Safely add the limits into the statement in replacement of the question mark
             */
           this.preparedStmt.setInt(1, low);
           this.preparedStmt.setInt(2, high);
           /* Safely execute the statement */
           this.rs = this.preparedStmt.executeQuery();
    
           /* Returns true if a result was found, false if not */
         /*  for (int i=0; i<high-low;i++) {*/
          /* int i=0;*/
           while (rs.next()) {
               /*Store everything in a new listing instince. */
               listing = new Objects.Listing(rs.getInt("LISTING_ID"), rs.getDouble("PRICE"),
                       rs.getInt("FK_UID"), rs.getDate("DATE_POSTED"), rs.getString("LISTING_TITLE"), 
                       rs.getString("DESCRIPTION"), rs.getString("CATEGORY")
                       );
               arrListing.add(listing);}
               
             /* i++;
           }*/
               
           
        } catch (SQLException e) {
            throw e;
        }
       
    
        return arrListing;
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