package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record CategoryRequestDto(
        @JsonProperty("name")
        @NotBlank(message = "CategoryRequestDto.name.notBlank")
        @NotEmpty(message = "CategoryRequestDto.name.notEmpty")
        @Length(max = 100, message = "CategoryRequestDto.name.maxLength")
        String name) {
}
