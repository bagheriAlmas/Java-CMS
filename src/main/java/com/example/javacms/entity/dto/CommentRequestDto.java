package com.example.javacms.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record CommentRequestDto(
        @JsonProperty("content")
        @NotBlank(message = "CommentRequestDto.content.notBlank")
        @NotEmpty(message = "CommentRequestDto.content.notEmpty")
        @Length(max = 100, message = "CommentRequestDto.content.maxLength")
        String content,

        @JsonProperty("articleId")
        @NotBlank(message = "CommentRequestDto.article.notBlank")
        @NotEmpty(message = "CommentRequestDto.article.notEmpty")
        @Length(max = 100, message = "CommentRequestDto.article.maxLength")
        long articleId,

        @JsonProperty("memberId")
        @NotBlank(message = "CommentRequestDto.member.notBlank")
        @NotEmpty(message = "CommentRequestDto.member.notEmpty")
        @Length(max = 100, message = "CommentRequestDto.member.maxLength")
        long memberId
) {
}
