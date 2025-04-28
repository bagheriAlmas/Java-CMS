package com.example.javacms.controller;

import com.example.javacms.entity.Category;
import com.example.javacms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    Category getCategoryById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    private void insertCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping("{id}")
    private void updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.update(category);
    }

    @DeleteMapping("{id}")
    private void updateCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }
}
