/*
 * Base class to interact with database
 * Adam Flammino 11/3/17
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDBFunctions {

    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Connects to database
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

    /**
     * Executes SQL statements
     * @param SQL
     * @param manip False if select, true for all other statements
     * @throws Exception 
     */
    public void executeSQL(String SQL, boolean manip) throws Exception {
        try {
            this.stmt = this.con.createStatement();
            if (!manip) {
                this.rs = this.stmt.executeQuery(SQL);
            } else {
                this.stmt.execute(SQL);
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    // Returns results set created by ExecuteSQL()
    public ResultSet getResults() {
        return this.rs;
    }
}
