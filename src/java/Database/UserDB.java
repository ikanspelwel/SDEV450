/**
 * Original created by Allison
 *
 * Adam Ring adding Prepared Statements to prevent against SQL injection.
 */
package Database;

//Imports
import Objects.User;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

//Begin Class UserDB
public class UserDB extends BaseDBFunctions {

    /**
     * Checks the database to see if username exists
     *
     * @param email
     * @return true if user exists false otherwise.
     * @throws SQLException
     */
    private boolean accountExists(String email) throws SQLException {
        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT `UID` FROM `USERS` WHERE `EMAIL` = ?"
            );

            /**
             * Safely add the email into the statement, in replacement of the
             * question mark.
             */
            this.preparedStmt.setString(1, email);

            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
            return rs.next();
        } catch (SQLException err) {
            throw err;
        }
    }

    /**
     * Inserts a new user into database
     *
     * @param fullName
     * @param email
     * @param password
     * @param zip
     * @return a user instance, if null there was an issue.
     * @throws SQLException
     */
    public Objects.User AddNewUser(String fullName, String email, String password, String zip) throws SQLException, IllegalArgumentException {

        /* Set the user object to null */
        Objects.User user = null;

        try {
            if (accountExists(email)) {
                throw new IllegalArgumentException("Account already exists.");
            } else {
                /* Create the salted hashed password. */
                String salt = Objects.User.RadomSalt();
                String hashedPass = Objects.User.HashPassword(password, salt);
                Date now = new java.sql.Date(System.currentTimeMillis());

                /* Setup a perpared statement */
                this.preparedStmt = this.con.prepareStatement(
                        "INSERT INTO `USERS` "
                        + "(`EMAIL`, `FULL_NAME`, `PASSWORD`,`SALT`, `ZIP`, `DATE_JOINED`) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );

                /**
                 * Safely add the values into the statement, in replacement of
                 * the question marks.
                 */
                this.preparedStmt.setString(1, email);
                this.preparedStmt.setString(2, fullName);
                this.preparedStmt.setString(3, hashedPass);
                this.preparedStmt.setString(4, salt);
                this.preparedStmt.setString(5, zip);
                this.preparedStmt.setDate(6, now);

                this.preparedStmt.executeUpdate();

                this.rs = preparedStmt.getGeneratedKeys();

                if (rs.next()) {
                    Integer uid = rs.getInt(1);

                    user = new Objects.User(uid, fullName, email, hashedPass, salt, "", zip, now);
                }
            }

        } catch (SQLException e) {
            throw e;
        }

        /* If we were unable to create the user it will return null */
        return user;
    }

    /**
     * Method to check if email/password combination match the database. Method
     * returns a user object or SQLException. If the user object is null no
     * matching account could be found.
     *
     * @param email
     * @param password
     * @return User Object could be null.
     * @throws SQLException
     */
    public Objects.User CheckLogIn(String email, String password) throws SQLException {
        /* Set the user object to null */
        Objects.User user = null;

        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `USERS` "
                    + "WHERE `EMAIL` = ? AND "
                    + "MD5(CONCAT(`SALT`, '/', ?)) = `PASSWORD`"
            );

            /**
             * Safely add the email and password into the statement, in
             * replacement of the question marks.
             */
            this.preparedStmt.setString(1, email);
            this.preparedStmt.setString(2, password);

            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
            if (rs.next()) {

                /* Store everying in a new user instance. */
                user = new User(rs.getInt("UID"), rs.getString("FULL_NAME"),
                        rs.getString("EMAIL"), rs.getString("PASSWORD"),
                        rs.getString("SALT"), rs.getString("RECOVERY_KEY"),
                        rs.getString("ZIP"), rs.getDate("DATE_JOINED"));
            }

        } catch (SQLException e) {
            throw e;
        }

        return user;
    }
    
    public Objects.User GetUser(Integer uID) throws SQLException {
        Objects.User user = null;

        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(
                    "SELECT * FROM `USERS` WHERE `UID` = ?"
            );

            /**
             * Safely add the email and password into the statement, in
             * replacement of the question marks.
             */
            this.preparedStmt.setInt(1, uID);

            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
            if (rs.next()) {

                /* Store everying in a new user instance. */
                user = new User(rs.getInt("UID"), rs.getString("FULL_NAME"),
                        rs.getString("EMAIL"), rs.getString("PASSWORD"),
                        rs.getString("SALT"), rs.getString("RECOVERY_KEY"),
                        rs.getString("ZIP"), rs.getDate("DATE_JOINED"));
            }

        } catch (SQLException e) {
            throw e;
        }

        return user;
    }

    /**
    //Changes user's password 
    public void changePassword(String userName, String oldPW, String newPW) {
        try {
            String sql = ("select Password from UserInfo where UserName="
                    + "'" + userName + "'");
            stmt.executeQuery(sql);
            if (rs.getString("Password").equals(oldPW)) { //double check logic for this
                sql = "Update UserInfo set Password=? where UserName=" + userName;
                preparedStmt = con.prepareStatement(sql);
                preparedStmt.setString(1, newPW);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Output incorrect password/username message
        }
    }
    */

} //End Class UserDB
