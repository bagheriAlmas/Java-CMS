package com.example.javacms.entity.dto;

import com.example.javacms.entity.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TagResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name) {

    public static Tag toEntity(TagResponseDto tagResponseDto) {
        Tag tag = new Tag();
        tag.setId(tagResponseDto.id);
        tag.setName(tagResponseDto.name);
        return tag;
    }
}
