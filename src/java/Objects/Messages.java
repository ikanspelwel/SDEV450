package Objects;

import java.sql.Date;

public class Messages {

    public Integer messageID, senderID, receiverID, listingRef, deleted;
    public Integer flagRead;
    public String messageText, listingTitle;
    public Date dateSent;

    /**
     * Constructor for Messages
     *
     * @param messageID
     * @param senderID
     * @param receiverID
     * @param listingRef
     * @param flagRead
     * @param messageText
     * @param dateSent
     * @param deleted
     */
    public Messages(Integer messageID, Integer senderID, Integer receiverID,
            Integer listingRef, Integer flagRead, String messageText,
            Date dateSent, Integer deleted) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.listingRef = listingRef;
        this.flagRead = flagRead;
        this.messageText = messageText;
        this.dateSent = dateSent;
        this.deleted = deleted;
    }
}
