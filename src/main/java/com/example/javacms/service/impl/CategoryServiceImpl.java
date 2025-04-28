package com.example.javacms.service.impl;

import com.example.javacms.entity.Category;
import com.example.javacms.entity.User;
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
    public Category findById(int id) {
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
