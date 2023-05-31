package com.elan.BookStore.Service;

import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.DTO.Request.BookRequest;
import com.elan.BookStore.Entity.Book;
import com.elan.BookStore.Repository.BookRepository;
import com.elan.BookStore.Validation.CustomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    @Autowired
    BookRepository repository;
    public ResponseEntity<Book> getBookDeatils(int id) throws NotFoundException {
       Optional<Book> book = repository.findById(id);
       if(book.isEmpty()){
           throw new NotFoundException("ID not found");
       }
       return ResponseEntity.status(HttpStatus.OK).body(book.get());
    }

    public ResponseEntity getAllBookDetails() throws NotFoundException {
        List<Book> bookList = repository.findAll();
        if(bookList.isEmpty()){
            throw new NotFoundException("ID not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    public ResponseEntity addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setDescription(bookRequest.getDescription());
        book.setPrice(bookRequest.getPrice());
        book.setBookType(bookRequest.getBookType());
        book.setYearOfPublication(bookRequest.getYearOfPublication());
        repository.save(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
}

    public ResponseEntity updateBook(int id, BookRequest bookRequest) throws NotFoundException {
        CustomValidation validation = new CustomValidation();
        Optional<Book> book = repository.findById(id);
        if(!book.isEmpty()){
            Book book1 = validation.updateValidation(book,bookRequest);
            book1=repository.save(book1);
            return ResponseEntity.status(HttpStatus.OK).body(book1);
        }
        else {
            throw new NotFoundException("ID not found");
        }
    }

    public ResponseEntity deleteBook(int id) throws NotFoundException {
        Optional<Book> book =repository.findById(id);
        if (book.isEmpty()){
            throw new NotFoundException("ID Not Found");
        }
        else{
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
        }
    }
}
