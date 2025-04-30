package com.example.javacms.entity.dto;

import com.example.javacms.entity.Article;
import com.example.javacms.entity.Member;
import com.fasterxml.jackson.annotation.JsonProperty;

public record MediaResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("url") String url,
        @JsonProperty("article") Article article,
        @JsonProperty("member") Member member) {
}
