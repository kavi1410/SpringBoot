package com.elan.BookStore.Controller;

import com.elan.BookStore.CustomException.AccessDeniedException;
import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.Service.BookAuthorService;
import com.elan.BookStore.Utils.Jwtservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookauthor/")
public class BookAuthorController {

    @Autowired
    BookAuthorService service;
   @Autowired
   Jwtservice jwtUtils;
    @GetMapping("get/")
    public ResponseEntity getAllDetails() throws NotFoundException {
        System.out.println("Controller getauthor");
        return service.getAllDetails();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getDetailsByID(@PathVariable("id")int id) throws NotFoundException, AccessDeniedException {
        return service.getdetailsByID(id);
    }
}