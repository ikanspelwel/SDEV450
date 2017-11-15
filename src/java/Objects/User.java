package Objects;

/**
 * @Course: SDEV 450 ~ Enterprise Java Programming
 * @Author Name: Adam Ring
 * @Date: Nov 15, 2017
 * @Subclass User Description: Class for the core user object and supplemental
 * methods.
 */
//Imports
import java.util.Random;
import java.sql.Date;

public class User {

    private Integer uid;
    private String fullName;
    private String email;
    private String password;
    private String salt;
    private String recoverKey;
    private Integer zip;
    private Date dateJoined;
    private static final Random RAND = new Random();
    private static final String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwzyz"
            + "0123456789";

    /**
     * Constructor that will load up the user with values.
     *
     * @param uid
     * @param fullName
     * @param email
     * @param password
     * @param salt
     * @param recoverKey
     * @param zip
     * @param dateJoined
     */
    public User(Integer uid, String fullName, String email, String password, String salt, String recoverKey, Integer zip, Date dateJoined) {
        this.uid = uid;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.recoverKey = recoverKey;
        this.zip = zip;
        this.dateJoined = dateJoined;
    }

    /**
     * @return the uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @return the recoverKey
     */
    public String getRecoverKey() {
        return recoverKey;
    }

    /**
     * @return the zip
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * @return the dateJoined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * Simple method to return a random salt 10 chars long. Static so we can use
     * it independent of any specific instantiated instance.
     *
     * @return the random salt
     */
    public static String RadomSalt() {
        /**
         * Create a random salt and return it.
         */
        String newSalt = "";

        /**
         * Building a string of random chars from the randomChars var with a
         * length of 10.
         */
        for (int i = 1; i < 11; i++) {
            newSalt += RANDOMCHARS.charAt(RAND.nextInt(RANDOMCHARS.length()));
        }

        return newSalt;
    }

    /**
     * Method to hash a password, static so we can use it independent of any
     * specific instantiated instance.
     *
     * @param password
     * @param salt
     * @return
     */
    public static String HashPassword(String password, String salt) {
        /* Calling the md5 hash from the Hash Class */
        return Tools.Hash.md5(salt + "/" + password);
    }

}
