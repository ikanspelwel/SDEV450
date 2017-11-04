/*
 * Adam Flammino 11/3/17
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Flammino
 */
public class BaseDBFunctions {

    String host;
    String username;
    String password;
    Connection con;
    Statement stmt;
    ResultSet rs;

    // Constructor
    BaseDBFunctions(String h, String u, String p) {
        host = h;
        username = u;
        password = p;
    }

    // Connects to database, returns true if sucessful
    boolean connect() {
        try {
            con = DriverManager.getConnection(host, username, password);
            return true;
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
            return false;
        }
    }
    
    // Executes whatever sql statement is passed in, returns true if sucessful
    boolean executeSQL(String SQL){
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            return true;
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
            return false;
        }
    }
    
    // Returns results set created by ExecuteSQL()
    ResultSet getResults(){
        return rs;
    }
}
