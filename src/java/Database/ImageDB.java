/**
 * Base Stub by Allison, expansion and DB integration by Adam Ring.  
 * getImages and lookupImage by Kyle holmes
 */
package Database;

import Objects.Listing;
import Objects.Images;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

//Begin Class ImageDB
public class ImageDB extends BaseDBFunctions {

    public void SaveImage(String imageType, Integer listingID, InputStream imageFile) throws SQLException {
        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(
                    "INSERT INTO `IMAGES` "
                    + "(`IMAGE_TYPE`, `FK_LISTING_ID`, `IMAGE`) "
                    + "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            /**
             * Safely add the values into the statement, in replacement of the
             * question marks.
             */
            this.preparedStmt.setString(1, imageType);
            this.preparedStmt.setInt(2, listingID);
            this.preparedStmt.setBlob(3, imageFile);

            this.preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.preparedStmt.close();
        }

    }
    public Images getImages(int image_id) throws SQLException {
        Images image = new Images();
        try{
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `IMAGES` "
                            + "WHERE `IMAGE_ID` =? ");
            /**
             * Safely add the limits into the statement in replacement of the question mark
             */
           this.preparedStmt.setInt(1, image_id);
           /* Safely execute the statement */
           this.rs = this.preparedStmt.executeQuery();
    
           /* Returns true if a result was found, false if not */
         /*  for (int i=0; i<high-low;i++) {*/
          /* int i=0;*/
           if (rs.next()) {
               /*Store everything in a new listing instince. */
               image = new Objects.Images(rs.getInt("IMAGE_ID"), rs.getInt("FK_LISTING_ID"),
                       rs.getString("IMAGE_TYPE"), rs.getString("IMAGE_METADATA"), rs.getBlob("IMAGE")
                       );
               }
          
           
               
             /* i++;
           }*/
               
           
        } catch (SQLException e) {
            throw e;
        } finally {
            this.preparedStmt.close();
        }
       
    
        return image;
    }
    
    public ArrayList<Integer> lookupImage(int listing_id) throws SQLException {
        ArrayList<Integer> arrImage = new ArrayList<>();
        Images image = new Images();
        try{
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `IMAGES` "
                            + "WHERE `FK_LISTING_ID` =? ");
            /**
             * Safely add the limits into the statement in replacement of the question mark
             */
           this.preparedStmt.setInt(1, listing_id);
           /* Safely execute the statement */
           this.rs = this.preparedStmt.executeQuery();
    
           /* Returns true if a result was found, false if not */
         /*  for (int i=0; i<high-low;i++) {*/
          /* int i=0;*/
           while (rs.next()) {
               /*Store everything in a new listing instince. */
               image = new Objects.Images(rs.getInt("IMAGE_ID"), rs.getInt("FK_LISTING_ID"),
                       rs.getString("IMAGE_TYPE"), rs.getString("IMAGE_METADATA"), rs.getBlob("IMAGE")
                       );
               arrImage.add(image.getImageid());
               }
          
           
               
             /* i++;
           }*/
               
           
        } catch (SQLException e) {
            throw e;
        } finally {
            this.preparedStmt.close();
        }
       
    
        return arrImage;
    }

    
} //End Class ImageDB
