package com.example.javacms.service;

import com.example.javacms.entity.Article;
import com.example.javacms.entity.dto.ArticleRequestDto;
import com.example.javacms.entity.dto.ArticleResponseDto;

import java.util.List;

public interface ArticleService {
    List<ArticleResponseDto> findAll();

    ArticleResponseDto findById(long id);

    void save(ArticleRequestDto requestDto);

    void update(long id, ArticleRequestDto requestDto);

    void deleteById(long id);
}
