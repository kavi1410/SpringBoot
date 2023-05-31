package com.elan.BookStore.CustomExceptionHandler;

import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.CustomException.AccessDeniedException;
import com.elan.BookStore.Model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModel> notFound(NotFoundException ex){
        ErrorModel errorMessage = ErrorModel.builder()
                .Status(HttpStatus.NOT_FOUND.value())
                .Message(ex.getMsg())
                .TimeStamp(LocalDateTime.now())
                .Error(HttpStatus.NOT_FOUND.name())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorModel> accessDenied(AccessDeniedException ex){
        ErrorModel errorMessage = ErrorModel.builder()
                .Error(HttpStatus.UNAUTHORIZED.name())
                .Message(ex.getMsg())
                .TimeStamp(LocalDateTime.now())
                .Status(HttpStatus.UNAUTHORIZED.value())
                .build();
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }
}
