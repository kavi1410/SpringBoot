package com.elan.BookStore.Controller;

import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.DTO.Request.LoginRequest;
import com.elan.BookStore.DTO.Request.UserRequest;
import com.elan.BookStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("signup/")
    public ResponseEntity signup(@RequestBody UserRequest userRequest){
        return service.signup(userRequest);
    }

    @PostMapping("login/")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) throws NotFoundException {
        return service.login(loginRequest);
    }
}
