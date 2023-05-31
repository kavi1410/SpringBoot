package com.elan.BookStore.CustomException;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NotFoundException extends Throwable {
    String msg;
    public NotFoundException(String msg){
        this.msg = msg;
    }

}
