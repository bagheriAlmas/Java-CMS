package com.example.javacms.service.impl;

import com.example.javacms.entity.Category;
import com.example.javacms.entity.dto.CategoryRequestDto;
import com.example.javacms.entity.dto.CategoryResponseDto;
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
    public List<CategoryResponseDto> findAll() {
        final var categoryList = categoryRepository.findAll();
        return categoryList.stream().map(Category::toDto).toList();
    }

    @Override
    public CategoryResponseDto findById(long id) {
        final var category = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
        return Category.toDto(category);
    }

    @Override
    public void save(CategoryRequestDto requestDto) {
        final var category = Category.fromDto(requestDto);
        categoryRepository.save(category);
    }

    @Override
    public void update(long id, CategoryRequestDto requestDto) {
        final var dbCategory = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
        dbCategory.setName(requestDto.name());
        categoryRepository.save(dbCategory);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
