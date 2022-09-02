package com.example.restdemo.controller;

import com.example.restdemo.model.User;
import com.example.restdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Giver JSON, og ikke en website
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Læser en bruger ud fra ID
    @GetMapping("{userId}")
    public User getUserDetails(@PathVariable("userId") long userId){
        return userService.getUser(userId);
    }

    //Læser alle brugere fra databasen
    @GetMapping()
    public List<User> getAllUserDetails(){
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User created";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "User updated";
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "User deleted";
    }
}
