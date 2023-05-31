package com.elan.BookStore.CustomMessage;

import com.elan.BookStore.Model.MessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class Message {
    public MessageModel customMessage(String msg) {

        MessageModel messageModel = MessageModel
                .builder()
                .Message(msg)
                .Status(HttpStatus.OK.value())
                .TimeStamp(LocalDateTime.now())
                .build();
        return messageModel;
    }
}
