package com.example.restdemo.controller;

import com.example.restdemo.model.User;
import com.example.restdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Giver JSON, og ikke en website
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Læser en bruger ud fra ID
    @GetMapping("{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable("userId") long userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    //Læser alle brugere fra databasen
    @GetMapping()
    public List<User> getAllUserDetails(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "User deleted";
    }

}
