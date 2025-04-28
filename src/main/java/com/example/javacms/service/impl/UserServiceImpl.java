package com.example.javacms.service.impl;

import com.example.javacms.entity.User;
import com.example.javacms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(long id) {

    }
}
