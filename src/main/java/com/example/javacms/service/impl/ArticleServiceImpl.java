package com.example.javacms.service.impl;

import com.example.javacms.entity.Article;
import com.example.javacms.entity.User;
import com.example.javacms.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public List<Article> findAll() {
        return List.of();
    }

    @Override
    public Article findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
