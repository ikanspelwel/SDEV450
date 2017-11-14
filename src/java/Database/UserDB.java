/**
 * Original created by Allison
 *
 * Adam Ring adding Prepared Statements to prevent againts SQL injection.
 */
package Database;

//Imports
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

//Begin Class UserDB
public class UserDB extends BaseDBFunctions {

    /* Include an instance of our User Object. */
    protected Objects.User user;

    // Checks database to see if username exists
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

    //Inserts new user information into database 
    public Objects.User newUser(String fullName, String email, String password, Integer zip) throws SQLException {

        Objects.User user = null;

        try {
            if (!accountExists(email)) {
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
                this.preparedStmt.setInt(5, zip);
                this.preparedStmt.setDate(6, now);
                
                this.preparedStmt.executeUpdate();

                this.rs = preparedStmt.getGeneratedKeys();

                if (rs.next()) {
                    Integer uid = rs.getInt(1);
                    
                    this.user = new Objects.User(uid, fullName, email, hashedPass, salt, "", zip, now);
                }
            }

        } catch (SQLException e) {
            throw e;
        }

        /* If we were unable to create the user it will return null */
        return this.user;
    }
    //Logs user into site

    public boolean logIn(String email, String pw) {
        boolean loggedIn = false;
        try {
            if (accountExists(email) == true) {
                String sql = ("select Password from UserInfo where UserName="
                        + "'" + email + "'");
                stmt.executeQuery(sql);
                if (rs.getString("Password").equals(pw)) { //double check logic for this
                    loggedIn = true;
                }
            } else {
                //Output error message to login/signup html page
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return loggedIn;
    }

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

} //End Class UserDB
