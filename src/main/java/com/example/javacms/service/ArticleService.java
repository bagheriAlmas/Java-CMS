package com.example.javacms.service;

import com.example.javacms.entity.Article;
import com.example.javacms.entity.User;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article findById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
