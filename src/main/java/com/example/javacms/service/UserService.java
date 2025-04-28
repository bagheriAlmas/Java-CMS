package com.example.javacms.service;

import com.example.javacms.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(User user);

    void deleteById(long id);
}
