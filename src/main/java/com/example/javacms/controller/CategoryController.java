package com.example.javacms.controller;

import com.example.javacms.entity.Category;
import com.example.javacms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    void insertCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping("{id}")
    void updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.update(id, category);
    }

    @DeleteMapping("{id}")
    void updateCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }
}
