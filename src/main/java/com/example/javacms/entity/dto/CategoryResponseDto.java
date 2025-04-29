package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name) {
}
