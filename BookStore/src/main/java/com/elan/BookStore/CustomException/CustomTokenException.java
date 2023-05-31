package com.elan.BookStore.CustomException;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomTokenException extends RuntimeException {

    String msg;
    public CustomTokenException(String msg) {
        this.msg=msg;
    }
}
