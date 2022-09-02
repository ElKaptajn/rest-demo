package com.example.restdemo.service;

import com.example.restdemo.model.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(long userId);
    public User getUser(long userId);
    public List<User> getAllUsers();
}

//Evt. lav en CRUD interface med værdige