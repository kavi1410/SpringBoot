package com.elan.RestController.CustomException;

import org.springframework.stereotype.Component;

import java.util.List;

public class UserDetailsException extends RuntimeException{

    List<String> ErrorList, DetailList;
    public UserDetailsException(List<String> ErrorList, List<String> DetailList) {
        this.ErrorList=ErrorList;
        this.DetailList=DetailList;
        System.out.println("constructor user exception");
    }

    public List<String> getDetailList() {
        return DetailList;
    }

    public List getList() {
        return ErrorList;
    }
}
