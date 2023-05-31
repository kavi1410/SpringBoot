package com.elan.BookStore.DTO.Request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    String Name;
    String Description;
    Integer YearOfPublication;
    String BookType;
    double Price;
}
