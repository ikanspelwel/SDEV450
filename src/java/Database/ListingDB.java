/**
 * inOrder and getListing by Kyle Holmes
 * newListing by Adam Flammino
 * Added html escaping to prevent CSS - Adam Ring
 */package Database;

//Imports
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import Objects.Listing;
import java.sql.Date;
import org.springframework.web.util.HtmlUtils;
//Begin Class User

public class ListingDB extends BaseDBFunctions {

    //Pulls listings in order
    public ArrayList<Listing> inOrder(int low, int high) throws SQLException {
        ArrayList<Listing> arrListing = new ArrayList<>();
        Objects.Listing listing = null;
        try {
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `LISTINGS` "
                    + "ORDER BY `LISTING_ID` DESC "
                    + "LIMIT ?, ?");
            /**
             * Safely add the limits into the statement in replacement of the
             * question mark
             */
            this.preparedStmt.setInt(1, low);
            this.preparedStmt.setInt(2, high);
            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            while (rs.next()) {
                /*Store everything in a new listing instince. */
                listing = new Objects.Listing(rs.getInt("LISTING_ID"), rs.getDouble("PRICE"),
                        rs.getInt("FK_UID"), rs.getDate("DATE_POSTED"), HtmlUtils.htmlEscape(rs.getString("LISTING_TITLE")),
                        HtmlUtils.htmlEscape(rs.getString("DESCRIPTION")), HtmlUtils.htmlEscape(rs.getString("CATEGORY"))
                );
                arrListing.add(listing);
            }

            /* i++;
           }*/
        } catch (SQLException e) {
            throw e;
        }

        return arrListing;
    }

    //Pulls listings in order
    public Listing getListing(int listing_id) throws SQLException {
        Objects.Listing listing = null;
        try {
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `LISTINGS` "
                    + "WHERE `LISTING_ID` = ? ");
            /**
             * Safely add the limits into the statement in replacement of the
             * question mark
             */
            this.preparedStmt.setInt(1, listing_id);
            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
 /*  for (int i=0; i<high-low;i++) {*/
 /* int i=0;*/
            while (rs.next()) {
                /*Store everything in a new listing instince. */
                listing = new Objects.Listing(rs.getInt("LISTING_ID"), rs.getDouble("PRICE"),
                        rs.getInt("FK_UID"), rs.getDate("DATE_POSTED"), HtmlUtils.htmlEscape(rs.getString("LISTING_TITLE")),
                        HtmlUtils.htmlEscape(rs.getString("DESCRIPTION")), HtmlUtils.htmlEscape(rs.getString("CATEGORY"))
                );
            }

            /* i++;
           }*/
        } catch (SQLException e) {
            throw e;
        }

        return listing;
    }

    /**
     * Adds new listing
     *
     * @param title
     * @param description
     * @param category
     * @param uid
     * @param price
     * @return new listing
     * @throws SQLException
     * @throws IllegalArgumentException
     */
    public int newListing(String title, String description,
            String category, int uid, double price) throws SQLException {

        try {
            Date now = new java.sql.Date(System.currentTimeMillis());

            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(
                    "INSERT INTO `LISTINGS` "
                    + "(`LISTING_TITLE`, `DESCRIPTION`, `CATEGORY`,`FK_UID`, `DATE_POSTED`, `PRICE`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            /**
             * Safely add the values into the statement, in replacement of the
             * question marks.
             */
            this.preparedStmt.setString(1, title);
            this.preparedStmt.setString(2, description);
            this.preparedStmt.setString(3, category);
            this.preparedStmt.setInt(4, uid);
            this.preparedStmt.setDate(5, now);
            this.preparedStmt.setDouble(6, price);

            this.preparedStmt.executeUpdate();
            this.rs = preparedStmt.getGeneratedKeys();
            int listingID = -1;
            if (rs.next()) {
               listingID = rs.getInt(1); 
            }
            
            return listingID;
        } catch (SQLException e) {
            throw e;
        }
    }

    //Links to paypal to purchase item?
    public void buyListing() {
    }
} //End Class User
