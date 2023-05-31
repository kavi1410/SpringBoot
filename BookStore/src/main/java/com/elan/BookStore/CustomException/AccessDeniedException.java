package com.elan.BookStore.CustomException;

public class AccessDeniedException extends Throwable {
    String msg;

    public String getMsg() {
        return msg;
    }

    public AccessDeniedException(String msg) {
        this.msg = msg;
    }
}
