package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CommentResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("content") String content,
        @JsonProperty("article") long article,
        @JsonProperty("member") long member
) {
}
