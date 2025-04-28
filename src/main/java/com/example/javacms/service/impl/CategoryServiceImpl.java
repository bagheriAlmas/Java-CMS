package com.example.javacms.service.impl;

import com.example.javacms.entity.Category;
import com.example.javacms.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category findById(long id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void deleteById(long id) {

    }
}
