package com.elan.BookStore.Service;

import com.elan.BookStore.CustomException.NotFoundException;
import com.elan.BookStore.CustomMessage.Message;
import com.elan.BookStore.CustomMessage.Token;
import com.elan.BookStore.DTO.Request.LoginRequest;
import com.elan.BookStore.DTO.Request.UserRequest;
import com.elan.BookStore.Entity.User;
import com.elan.BookStore.Repository.UserRepository;
import com.elan.BookStore.Utils.Jwtservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    Jwtservice jwtUtils;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Message message;
    @Autowired
    Token token;
    public ResponseEntity signup(UserRequest userRequest) {
        User user = new User();
        user.setId(user.getId());
        user.setName(userRequest.getName());
        user.setEmailID(userRequest.getEmailID());
        user.setUserName(userRequest.getUserName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setIsActive(user.getIsActive());
        user.setCreatedAt(user.getCreatedAt());
        user.setUpdatedAt(user.getUpdatedAt());
        user.setLastLogin(user.getLastLogin());
        user.setRole(user.getRole());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(message.customMessage("User Account Created Successfully"));
    }

    public ResponseEntity login(LoginRequest loginRequest) throws NotFoundException {
        Optional<User> username = userRepository.findByuserName(loginRequest.getUserName());
        if (username.isEmpty()){
            throw new NotFoundException("Username Not Found");
        }
        Optional<User> user = userRepository.findByuserNameAndPassword(loginRequest.getUserName(),loginRequest.getPassword());
        if(user.isEmpty()){
            throw new NotFoundException("User Details Not Found");
        }
        System.out.println("loginservice"+user);
        return ResponseEntity.status(HttpStatus.FOUND).body(token.tokenMessage(jwtUtils.generateToken(user.get())));
    }
}
