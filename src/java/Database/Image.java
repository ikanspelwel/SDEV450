package Database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


//Begin Class Image
public class Image {

    String imageName;

    Image(String file) {
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

} //End Class Image
