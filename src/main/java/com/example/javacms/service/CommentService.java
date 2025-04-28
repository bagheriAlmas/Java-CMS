package com.example.javacms.service;

import com.example.javacms.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(long id);

    void save(Comment comment);

    void update(Comment comment);

    void deleteById(long id);
}
