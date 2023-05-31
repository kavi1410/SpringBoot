package com.elan.BookStore.Controller;


import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.DTO.Request.BookRequest;
import com.elan.BookStore.Entity.Book;
import com.elan.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/")
public class BookController {

    @Autowired
    BookService service;
    @GetMapping("get/{id}")
    public ResponseEntity<Book> getBookDetails(@PathVariable("id") int id) throws NotFoundException {
        return service.getBookDeatils(id);
    }

    @GetMapping("get/")
    public ResponseEntity<Book> getAllBookDetails() throws NotFoundException {
        return service.getAllBookDetails();
    }

    @PostMapping("add/")
    public ResponseEntity addBook(@RequestBody BookRequest bookRequest){
        return service.addBook(bookRequest);
    }
    @PatchMapping("update/{id}")
    public ResponseEntity updateBook(@PathVariable("id") int id, @RequestBody BookRequest bookRequest) throws NotFoundException {
        return service.updateBook(id,bookRequest);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletebook(@PathVariable("id") int id) throws NotFoundException {
        return service.deleteBook(id);
    }
}
