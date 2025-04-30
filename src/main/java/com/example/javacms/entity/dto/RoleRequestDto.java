package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record RoleRequestDto(
        @JsonProperty("name")
        @NotBlank(message = "RoleRequestDto.name.notBlank")
        @NotEmpty(message = "RoleRequestDto.name.notEmpty")
        @Length(max = 100, message = "RoleRequestDto.name.maxLength") String roleName) {
}
