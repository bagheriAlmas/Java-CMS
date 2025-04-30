package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record ArticleRequestDto(

        @JsonProperty("title")
        @NotBlank(message = "ArticleRequestDto.title.notBlank")
        @NotEmpty(message = "ArticleRequestDto.title.notEmpty")
        @Length(max = 100, message = "ArticleRequestDto.title.maxLength")
        String title,

        @JsonProperty("content")
        @NotBlank(message = "ArticleRequestDto.content.notBlank")
        @NotEmpty(message = "ArticleRequestDto.content.notEmpty")
        @Length(max = 100, message = "ArticleRequestDto.content.maxLength")
        String content,

        @JsonProperty("category")
        @NotBlank(message = "ArticleRequestDto.category.notBlank")
        @NotEmpty(message = "ArticleRequestDto.category.notEmpty")
        @Length(max = 100, message = "ArticleRequestDto.category.maxLength")
        long categoryId,

        @JsonProperty("member")
        @NotBlank(message = "ArticleRequestDto.member.notBlank")
        @NotEmpty(message = "ArticleRequestDto.member.notEmpty")
        @Length(max = 100, message = "ArticleRequestDto.member.maxLength")
        long memberId,

        @JsonProperty("tags")
        @NotBlank(message = "ArticleRequestDto.tags.notBlank")
        @NotEmpty(message = "ArticleRequestDto.tags.notEmpty")
        @Length(max = 100, message = "ArticleRequestDto.tags.maxLength")
        List<Long> tagsId) {
}
