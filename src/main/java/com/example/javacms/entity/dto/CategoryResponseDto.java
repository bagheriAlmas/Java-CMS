package com.example.javacms.entity.dto;

import com.example.javacms.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name) {

    public static Category toEntity(CategoryResponseDto dto) {
        Category category = new Category();
        category.setId(dto.id);
        category.setName(dto.name);
        return category;
    }
}
