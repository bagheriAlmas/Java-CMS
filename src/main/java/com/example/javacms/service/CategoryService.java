package com.example.javacms.service;

import com.example.javacms.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void update(Category category);

    void deleteById(int id);
}
