package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Ari
 * @Assignment Name: Database
 * @Date: Nov 9, 2017
 * @Subclass Message Description: 
 */
//Imports

//Begin Subclass Messages
public class Messages extends BaseDBFunctions {

    String sender;
    String recipient;    
    String msgContents;

    Messages(String msg, String toUser, String fromUser) {
        msg = msgContents;
        toUser = recipient;
        fromUser = sender;
    }
    
    public void newMessage(){
        String sql = "insert into Messages (Sender, Recipient, Message) values "
                + "('"+sender+"','"+recipient+"','"+msgContents+"')";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    //Deletes message using message ID associated with HTML checkbox
    public void deleteMessage(int msgID){
        String sql = ("delete from Messages where MessageID =" + "'"+msgID+"'");
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
} //End Subclass Messages