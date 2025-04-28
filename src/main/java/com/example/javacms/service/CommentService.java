package com.example.javacms.service;

import com.example.javacms.entity.Comment;
import com.example.javacms.entity.User;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
