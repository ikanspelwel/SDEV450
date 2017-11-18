/**
 * Base Stub by Allison, expansion and DB integration by Adam Ring.
 */
package Database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Statement;
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
