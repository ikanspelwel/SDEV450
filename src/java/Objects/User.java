/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Random;
import java.sql.Date;

/**
 *
 * @author ikanspelwel
 */
public class User {

    protected Integer uid;
    protected String fullName;
    protected String email;
    protected String password;
    protected String salt;
    protected String recoverKey;
    protected Integer zip;
    protected Date dateJoined;
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

        System.out.printf("Salt Length: %d\n", newSalt.length());
        
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
