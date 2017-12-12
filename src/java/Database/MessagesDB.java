package Database;

import Objects.Messages;
import java.sql.SQLException;
import org.springframework.web.util.HtmlUtils;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Allison
 * @Assignment Name: Database
 * @Date: Nov 9, 2017
 * @Subclass Message Description: Original Base code by Allison. Converted to
 * stored procedures by Adam Ring, and added GetMessages method.
 */
//Imports
import java.util.ArrayList;

//Begin Subclass MessagesDB
public class MessagesDB extends BaseDBFunctions {

    /**
     * Adds a new message to the db.
     * 
     * @param message
     * @throws SQLException 
     */
    public void newMessage(Objects.Messages message) throws SQLException {

        /* Setup a perpared statement */
        this.preparedStmt = this.con.prepareStatement(
                "INSERT INTO `MESSAGES` "
                + "(`FK_SENDER_ID`, `LISTING_REF`, `FK_RECEIVER_ID`, `MESSAGE_TEXT`) "
                + "VALUES (?, ?, ?, ?)"
        );

        /**
         * Safely add the values into the statement, in replacement of the
         * question marks.
         */
        this.preparedStmt.setInt(1, message.senderID);
        this.preparedStmt.setInt(2, message.listingRef);
        this.preparedStmt.setInt(3, message.receiverID);
        this.preparedStmt.setString(4, message.messageText);

        this.preparedStmt.executeUpdate();

    }

    /**
     * Method to retrieve all the messages of a certain type, and return them in
     * an ArrayList of Message Objects.
     *
     * Created by Adam Ring.
     *
     * @param userID The userID to retrieve messages for.
     * @param msgType The type of message to get.
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<Objects.Messages> GetMessages(Integer userID, String msgType) throws SQLException {
        // Array of Messages
        ArrayList<Objects.Messages> allMessages = new ArrayList<>();
        Objects.Messages newMessage = null;

        String selectStatement = "SELECT `MESSAGES`.*, `LISTINGS`.`LISTING_TITLE`"
                + " FROM `MESSAGES` LEFT JOIN `LISTINGS` "
                + "ON `MESSAGES`.`LISTING_REF` = `LISTINGS`.`LISTING_ID` WHERE ";

        /**
         * Simple switch, based on the value of msgType.
         */
        switch (msgType) {
            case "Inbox":
                // FK_RECEIVER_ID
                selectStatement += "`FK_RECEIVER_ID` = ? AND `DELETED` = 0";
                break;

            case "Sent":
                // FK_SENDER_ID
                selectStatement += "`FK_SENDER_ID` = ? AND `DELETED` = 0";
                break;

            case "Trash":
                // FK_RECEIVER_ID or FK_SENDER_ID
                selectStatement += "(`FK_RECEIVER_ID` = ? OR `FK_SENDER_ID` = ?) "
                        + "AND `DELETED` = 1";
                break;

            default:
                break;
        }

        // Adding sort clauses.
        selectStatement += " ORDER BY `FLAG_READ` DESC, `DATE_SENT` DESC";

        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(selectStatement);

            /**
             * Safely add the email and password into the statement, in
             * replacement of the question marks.
             */
            this.preparedStmt.setInt(1, userID);
            if (msgType.equals("Trash")) {
                // If trash we need to search for userID in either field.
                this.preparedStmt.setInt(2, userID);
            }

            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
            while (rs.next()) {

                newMessage = new Messages(rs.getInt("MESSAGE_ID"),
                        rs.getInt("FK_SENDER_ID"), rs.getInt("FK_RECEIVER_ID"),
                        rs.getInt("LISTING_REF"), rs.getInt("FLAG_READ"),
                        HtmlUtils.htmlEscape(rs.getString("MESSAGE_TEXT")), rs.getDate("DATE_SENT"),
                        rs.getInt("DELETED"));

                newMessage.listingTitle = HtmlUtils.htmlEscape(rs.getString("LISTING_TITLE"));

                /* Add all messages in the ArrayList. */
                allMessages.add(newMessage);
            }

        } catch (SQLException e) {
            throw e;
        }

        // Return the ArrayList
        return allMessages;
    }

    /**
     * Method to retrieve the contents of a message from the dB. 
     * 
     * @param msgID
     * @return message object.
     * @throws SQLException 
     */
    public Objects.Messages GetMessage(int msgID) throws SQLException {
        Objects.Messages message = null;

        String selectStatement = "SELECT * FROM `MESSAGES` WHERE `MESSAGE_ID` = ?";

        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(selectStatement);

            /**
             * Safely add the messageID into the statement, in replacement of
             * the question marks.
             */
            this.preparedStmt.setInt(1, msgID);

            /* Safely execute the statement */
            this.rs = this.preparedStmt.executeQuery();

            /* Returns true if a result was found, false if not */
            if (rs.next()) {

                message = new Messages(rs.getInt("MESSAGE_ID"),
                        rs.getInt("FK_SENDER_ID"), rs.getInt("FK_RECEIVER_ID"),
                        rs.getInt("LISTING_REF"), rs.getInt("FLAG_READ"),
                        HtmlUtils.htmlEscape(rs.getString("MESSAGE_TEXT")), rs.getDate("DATE_SENT"),
                        rs.getInt("DELETED"));
            }
        } catch (SQLException e) {
            throw e;
        }

        return message;
    }

    /**
     * Marks a message as deleted in the db.
     * 
     * @param msgID
     * @throws SQLException 
     */
    public void DeleteMessage(int msgID) throws SQLException {

        String updateStatement = "UPDATE `MESSAGES` SET `DELETED` = 1 WHERE `MESSAGE_ID` = ?";

        try {
            /* Setup a perpared statement */
            this.preparedStmt = this.con.prepareStatement(updateStatement);

            /**
             * Safely add the messageID into the statement, in replacement of
             * the question marks.
             */
            this.preparedStmt.setInt(1, msgID);

            /* Safely execute the statement */
            this.preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }

    }
} //End Subclass MessagesDB
