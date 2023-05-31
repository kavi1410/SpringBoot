package com.elan.BookStore.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class MessageModel {
    private String Message;
    private Integer Status;
    private LocalDateTime TimeStamp;
}
