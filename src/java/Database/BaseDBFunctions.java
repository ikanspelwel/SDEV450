/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Flammino
 */
public class BaseDBFunctions {

    String host;
    String username;
    String password;
    Connection con;

    // Constructor
    BaseDBFunctions(String h, String u, String p) {
        host = h;
        username = u;
        password = p;
    }

    // Connects to database, returns true if sucessful
    boolean Connect() {
        try {
            con = DriverManager.getConnection(host, username, password);
            return true;
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
            return false;
        }
    }
}
