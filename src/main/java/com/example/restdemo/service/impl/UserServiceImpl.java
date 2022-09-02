package com.example.restdemo.service.impl;

import com.example.restdemo.model.User;
import com.example.restdemo.repository.UserRepository;
import com.example.restdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        //Forretnings logik skal skrives her
        userRepository.save(user);
        return "User successfully created";
    }

    @Override
    public String updateUser(User user) {
        //Forretnings logik skal skrives her
        userRepository.save(user);
        return "User updated";
    }

    @Override
    public String deleteUser(long userId) {
        //Forretnings logik skal skrives her
        userRepository.deleteById(userId);
        return "User with the id " + userId + " has been deleted";
    }

    @Override
    public User getUser(long userId) {
        //Forretnings logik skal skrives her
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        //Forretnings logik skal skrives her
        return userRepository.findAll();
    }
}
