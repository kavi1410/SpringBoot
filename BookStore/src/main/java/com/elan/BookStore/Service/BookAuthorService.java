package com.elan.BookStore.Service;

import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.DTO.Response.AuthorResponse;
import com.elan.BookStore.DTO.Response.BookResponse;
import com.elan.BookStore.Entity.Book;
import com.elan.BookStore.Entity.BookAuthor;
import com.elan.BookStore.Repository.BookAuthorRespository;
import com.elan.BookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookAuthorRespository bookAuthorRespository;
    public ResponseEntity getAllDetails() throws NotFoundException {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NotFoundException("ID Not Found");
        }
        List<BookAuthor> bookAuthors = bookAuthorRespository.findAll();
        BookResponse bookResponse = new BookResponse();
        for(Book book :books) {
            bookResponse.setId(book.getId());
            bookResponse.setBookType(book.getBookType());
            bookResponse.setName(book.getName());
            bookResponse.setPrice(book.getPrice());
            bookResponse.setDescription(book.getDescription());
            bookResponse.setYearOfPublication(book.getYearOfPublication());
        }
        List<AuthorResponse> authorResponseList = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthors) {
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setId(bookAuthor.getAuthor().getId());
            authorResponse.setGenre(bookAuthor.getAuthor().getGenre());
            authorResponse.setGender(bookAuthor.getAuthor().getGender());
            authorResponse.setName(bookAuthor.getAuthor().getName());
            authorResponseList.add(authorResponse);
        }
        bookResponse.setAuthor(authorResponseList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }

    public ResponseEntity getdetailsByID(Integer id) throws NotFoundException {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("ID Not Found");
        }
        List<BookAuthor> bookAuthors = bookAuthorRespository.findAllBybookId(id);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.get().getId());
        bookResponse.setBookType(book.get().getBookType());
        bookResponse.setName(book.get().getName());
        bookResponse.setPrice(book.get().getPrice());
        bookResponse.setDescription(book.get().getDescription());
        bookResponse.setYearOfPublication(book.get().getYearOfPublication());
        List<AuthorResponse> authorResponseList = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthors) {
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setId(bookAuthor.getAuthor().getId());
            authorResponse.setGenre(bookAuthor.getAuthor().getGenre());
            authorResponse.setGender(bookAuthor.getAuthor().getGender());
            authorResponse.setName(bookAuthor.getAuthor().getName());
            authorResponseList.add(authorResponse);
        }
        bookResponse.setAuthor(authorResponseList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }
        //--------------------------------------------------------------------------
//        List list = new ArrayList();
//        Iterable<BookAuthor> bookAuthorIterable = bookAuthorRespository.findAllBybookId(id);
//        Iterator<BookAuthor> bookAuthorIterator = bookAuthorIterable.iterator();
//        while(bookAuthorIterator.hasNext()){
//            list.add(bookAuthorIterator.next());
//        }
//
//
//        if(list.isEmpty()){
//            throw new NotFoundException("ID Not Found");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(list);
//    }


}

