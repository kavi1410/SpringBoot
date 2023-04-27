package com.elan.RestController.Message;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomMessage {

    private String message;



     LocalDateTime dateTime = LocalDateTime.now();

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomMessage  dataNotfound() {
        this.setMessage(" Data Not Found");
        return this;
    }

    public CustomMessage idNotfound() {
        this.setMessage(" Data Not Found");

        return this;
    }

    public CustomMessage Update() {
        this.setMessage(" Update successfully");
        return this;
    }

    public CustomMessage Delete() {
        this.setMessage( " Deleted Successfully");

        return this;
    }
}


