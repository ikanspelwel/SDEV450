package Objects;

import java.sql.Date;

public class Messages {

    protected Integer messageID, senderID, receiverID, listingRef, deleted;
    protected Integer flagRead;
    protected String messageText;
    protected Date dateSent;

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
