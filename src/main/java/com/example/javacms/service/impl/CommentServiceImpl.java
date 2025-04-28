package com.example.javacms.service.impl;

import com.example.javacms.entity.Comment;
import com.example.javacms.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {


    @Override
    public List<Comment> findAll() {
        return List.of();
    }

    @Override
    public Comment findById(long id) {
        return null;
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void deleteById(long id) {

    }
}
