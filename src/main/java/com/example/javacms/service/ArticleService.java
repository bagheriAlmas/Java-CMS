package com.example.javacms.service;

import com.example.javacms.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article findById(long id);

    void save(Article article);

    void update(Article article);

    void deleteById(long id);
}
