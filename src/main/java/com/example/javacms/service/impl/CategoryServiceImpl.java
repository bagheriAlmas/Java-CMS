package com.example.javacms.service.impl;

import com.example.javacms.entity.Category;
import com.example.javacms.repository.CategoryRepository;
import com.example.javacms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(long id, Category category) {
        Category dbCategory = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
        dbCategory.setName(category.getName());
        categoryRepository.save(dbCategory);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
