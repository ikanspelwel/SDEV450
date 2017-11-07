/*
 * Base class to interact with database
 * Adam Flammino 11/3/17
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDBFunctions {

    Connection con;
    Statement stmt;
    ResultSet rs;

    /**
     * 
     * @param host The database host to connect to.
     * @param username The username for the database.
     * @param password The password for the database.
     * @throws Exception 
     */
    public void connect(String host, String username, String password) throws Exception {
        try {
            /**
             * Including the MySQL JDBC class.
             */
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            /**
             * Connecting to the DB host with the provided user/password.
             */
            this.con = DriverManager.getConnection(host, username, password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            /* If there was an exception toss it back up to the calling program. */
            throw e;
        }
    }

    // Executes whatever sql statement is passed in, returns true if sucessful
    // Set manip to false for select statements, true for others
    public boolean executeSQL(String SQL, boolean manip) {
        try {
            this.stmt = this.con.createStatement();
            if (!manip) {
                this.rs = this.stmt.executeQuery(SQL);
            } else {
                this.stmt.execute(SQL);
            }
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    // Returns results set created by ExecuteSQL()
    public ResultSet getResults() {
        return this.rs;
    }
}
