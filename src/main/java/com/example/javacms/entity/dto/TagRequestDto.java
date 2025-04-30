package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record TagRequestDto(
        @JsonProperty("name")
        @NotBlank(message = "TagRequestDto.name.notBlank")
        @NotEmpty(message = "TagRequestDto.name.notEmpty")
        @Length(max = 100, message = "TagRequestDto.name.maxLength") String name) {
}
