package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TagRequestDto(@JsonProperty("name") String name) {
}
