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

    protected Connection con;
    protected Statement stmt;
    protected PreparedStatement preparedStmt;
    protected ResultSet rs;

    /**
     * Default constructor that will auto connect to our DB.
     *
     * @throws java.lang.Exception
     */
    public BaseDBFunctions() {
        /**
         * Demo DB
         */
        String host = "jdbc:mysql://sdev450.gmavt.net:3306/demo1";
        String username = "demo1";
        String password = "DirectSellDbAccess1234";
        /**
         * // Live DB
         * String host = "jdbc:mysql://localhost:3306/directsell";
         * String username = "directsell";
         * String password = "moscow-ugly-brussels";
         */
        try {
            this.connect(host, username, password);
        } catch (Exception e) {
            System.out.printf("DB Connection failed: %s\n", e.getMessage());
        }
    }

    /**
     * Connects to database
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

    /**
     * Executes SQL statements
     *
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
