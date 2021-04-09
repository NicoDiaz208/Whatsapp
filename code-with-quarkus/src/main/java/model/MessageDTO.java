package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MessageDTO {
    @JsonProperty("message")
    private String message;
    @JsonProperty("author")
    private String author;
    @JsonProperty("date")
    private Date date;

    public MessageDTO(String message, String author, Date date){
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public MessageDTO(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
