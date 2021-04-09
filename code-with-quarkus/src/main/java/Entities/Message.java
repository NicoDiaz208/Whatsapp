package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    private String message;
    private Date date;

    @ManyToOne
    private Membership membership;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int id) {
        this.messageId = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String payload) {
        this.message = payload;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
