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
    Connection con;
    Statement stmt;
    ResultSet rs;

    // Connects to database, returns true if sucessful
    boolean connect(String host, String username, String password) {
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
