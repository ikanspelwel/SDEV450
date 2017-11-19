package Objects;

import java.sql.Date;

public class Listing {

    protected Integer listingID;
    protected Double price;
    protected Integer UID;
    protected Date date;
    protected String listingTitle;
    protected String description;
    protected String category;    
    protected String email;
 

    /**
     * Constructor for Listing
     *
     * @param listingID
     * @param price
     * @param UID
     * @param date
     * @param listingTitle
     * @param description
     * @param category
     * @param email     
     */
    public Listing(){
        
    }
    public Listing(Integer listingID, Double price, Integer UID, Date date, 
            String listingTitle, String description, String category, String email){
        this.listingID = listingID;
        this.price= price;
        this.UID = UID;
        this.date = date;
        this.listingTitle = listingTitle;
        this.description = description;
        this.category = category;        
        this.email = email;        
    }


/**
     * @return the listingID
     */
    public Integer getListingid() {
        return listingID;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @return the user id
     */
    public Integer getUid() {
        return UID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the listing title
     */
    public String getListingTitle() {
        return listingTitle;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
}