package com.elan.BookStore.CustomMessage;


import com.elan.BookStore.Model.TokenModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Token {
    public TokenModel tokenMessage(String msg) {

        TokenModel token = TokenModel
                .builder()
                .Token(msg)
                .Status(HttpStatus.FOUND.value())
                .TimeStamp(LocalDateTime.now())
                .build();
        return token;
    }
}
