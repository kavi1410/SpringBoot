package com.elan.BookStore.DTO.Response;

import com.elan.BookStore.Entity.Author;
import com.elan.BookStore.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorResponse {
    List<Book> Book;
    List<Author> Author;
}
