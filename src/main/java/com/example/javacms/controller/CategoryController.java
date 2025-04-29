package com.example.javacms.controller;

import com.example.javacms.entity.dto.CategoryRequestDto;
import com.example.javacms.entity.dto.CategoryResponseDto;
import com.example.javacms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertCategory(@RequestBody CategoryRequestDto requestDto) {
        categoryService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequestDto requestDto) {
        categoryService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> updateCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
