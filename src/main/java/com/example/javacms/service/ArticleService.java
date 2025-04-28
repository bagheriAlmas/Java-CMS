package com.example.javacms.service;

import com.example.javacms.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article findById(int id);

    void save(Article article);

    void update(Article article);

    void deleteById(int id);
}
