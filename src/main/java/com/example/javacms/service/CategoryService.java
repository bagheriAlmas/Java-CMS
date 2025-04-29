package com.example.javacms.service;

import com.example.javacms.entity.dto.CategoryRequestDto;
import com.example.javacms.entity.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();

    CategoryResponseDto findById(long id);

    void save(CategoryRequestDto requestDto);

    void update(long id, CategoryRequestDto requestDto);

    void deleteById(long id);
}
