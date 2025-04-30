package com.example.javacms.entity.dto;

import com.example.javacms.entity.Article;
import com.example.javacms.entity.Category;
import com.example.javacms.entity.Member;
import com.example.javacms.entity.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ArticleResponseDto(
        @JsonProperty("id") Long id,
        @JsonProperty("title")String title,
        @JsonProperty("content")String content,
        @JsonProperty("category")Category category,
        @JsonProperty("member")Member member,
        @JsonProperty("tags")List<Tag> tags
) {
    public static Article toEntity(ArticleResponseDto article) {
        Article articleEntity = new Article();
        articleEntity.setId(article.id);
        articleEntity.setTitle(article.title);
        articleEntity.setContent(article.content);
        articleEntity.setCategory(article.category);
        articleEntity.setMember(article.member);
        articleEntity.setTags(article.tags);
        return articleEntity;
    }
}
