package com.elan.BookStore.Validation;

import com.elan.BookStore.DTO.Request.BookRequest;
import com.elan.BookStore.Entity.Book;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class CustomValidation {

    public Book updateValidation(Optional<Book> book, BookRequest bookRequest) {
        List<String> list = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(book.get().getId());
        if (bookRequest.getName() != null) {
            book1.setName(bookRequest.getName());
        } else {
            book1.setName(book.get().getName());
        }
        if (bookRequest.getDescription() != null) {
            book1.setDescription(bookRequest.getDescription());
        } else {
            book1.setDescription(book.get().getDescription());
        }
        if (bookRequest.getPrice() != 0.00) {
            book1.setPrice(bookRequest.getPrice());
        } else {
            book1.setPrice(book.get().getPrice());
        }
        if (bookRequest.getBookType() != null) {
            book1.setBookType(bookRequest.getBookType());
        } else {
            book1.setBookType(book.get().getBookType());
        }
        if (bookRequest.getYearOfPublication() != null) {
            book1.setYearOfPublication(bookRequest.getYearOfPublication());
        } else {
            book1.setYearOfPublication(book.get().getYearOfPublication());
        }
        book1.setCreatedAt(book.get().getCreatedAt());
        book1.setUpdatedAt(LocalDateTime.now());

    return book1;
    }
}
