package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record MediaRequestDto(

        @JsonProperty("url")
        @NotBlank(message = "MediaRequestDto.url.notBlank")
        @NotEmpty(message = "MediaRequestDto.url.notEmpty")
        @Length(max = 10, message = "MediaRequestDto.url.maxLength")
        String url,

        @JsonProperty("article")
        @NotBlank(message = "MediaRequestDto.article.notBlank")
        @NotEmpty(message = "MediaRequestDto.article.notEmpty")
        @Length(max = 10, message = "MediaRequestDto.article.maxLength")
        long articleId,

        @JsonProperty("member")
        @NotBlank(message = "MediaRequestDto.member.notBlank")
        @NotEmpty(message = "MediaRequestDto.member.notEmpty")
        @Length(max = 10, message = "MediaRequestDto.member.maxLength")
        long memberId
) {
}
