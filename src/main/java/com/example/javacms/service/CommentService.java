package com.example.javacms.service;

import com.example.javacms.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(int id);

    void save(Comment comment);

    void update(Comment comment);

    void deleteById(int id);
}
