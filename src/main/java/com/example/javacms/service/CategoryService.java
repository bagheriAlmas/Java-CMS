package com.example.javacms.service;

import com.example.javacms.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(long id);

    void save(Category category);

    void update(long id, Category category);

    void deleteById(long id);
}
