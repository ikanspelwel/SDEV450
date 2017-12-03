/**
 * Base Stub by Allison, expansion and DB integration by Adam Ring.
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
        }

    }
    public Images getImage(int listing_id) throws SQLException {
        Images image = new Images();
        try{
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `IMAGES` "
                            + "WHERE `FK_LISTING_ID` =? "
                            + "ORDER BY `IMAGE_ID` ASC "
            + "LIMIT 1");
            /**
             * Safely add the limits into the statement in replacement of the question mark
             */
           this.preparedStmt.setInt(1, listing_id);
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
        }
       
    
        return image;
    }

    /*
   
    String imageName;

    ImageDB(String file) {
        imageName = file;
    }

    public BufferedImage getImage() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imageName));
        } catch (IOException e) {
        }
        return img;
    }

     */
} //End Class ImageDB
