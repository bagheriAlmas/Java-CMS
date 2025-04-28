package com.example.javacms.service;

import com.example.javacms.entity.Tag;
import com.example.javacms.entity.User;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Tag findById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
