package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryRequestDto(@JsonProperty("name") String name) {
}
