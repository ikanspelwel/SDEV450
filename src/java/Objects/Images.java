package Objects;

import java.sql.Blob;


public class Images {

    protected Integer imageID, listingID;    
    protected String imageType, imageMeta;
    protected Blob image;
 
    /**
     * Constructor for Images
     *
     * @param imageID
     * @param listingID
     * @param imageType
     * @param imageMeta
     * @param image     
     */
    public Images(Integer imageID, Integer listingID, String imageType, 
            String imageMeta, Blob image){
        this.imageID = imageID;
        this.listingID = listingID;
        this.imageType = imageType;
        this.imageMeta = imageMeta;
        this.image = image;
    }
} 