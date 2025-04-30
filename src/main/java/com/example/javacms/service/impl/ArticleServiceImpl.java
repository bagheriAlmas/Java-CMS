package com.example.javacms.service.impl;

import com.example.javacms.common.exceptions.ArticleNotFoundException;
import com.example.javacms.entity.Article;
import com.example.javacms.entity.dto.ArticleRequestDto;
import com.example.javacms.entity.dto.ArticleResponseDto;
import com.example.javacms.entity.dto.CategoryResponseDto;
import com.example.javacms.entity.dto.TagResponseDto;
import com.example.javacms.repository.ArticleRepository;
import com.example.javacms.service.ArticleService;
import com.example.javacms.service.CategoryService;
import com.example.javacms.service.MemberService;
import com.example.javacms.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;
    private final MemberService memberService;
    private final TagService tagService;

    @Override
    public List<ArticleResponseDto> findAll() {
        final var articleList = articleRepository.findAll();
        return articleList.stream().map(Article::toDto).toList();
    }

    @Override
    public ArticleResponseDto findById(long id) {
        final var article = articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        return Article.toDto(article);
    }

    @Override
    public void save(ArticleRequestDto requestDto) {
        final var category = categoryService.findById(requestDto.categoryId());
        final var member = memberService.findById(requestDto.memberId());
        final var tags = tagService.findAll();
        final var tagsList = tags.stream().map(TagResponseDto::toEntity).toList();
        final var article = Article.fromDto(requestDto, CategoryResponseDto.toEntity(category), member, tagsList);
        articleRepository.save(article);
    }

    @Override
    public void update(long id, ArticleRequestDto requestDto) {
        final var dbArticle = articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        dbArticle.setTitle(requestDto.title());
        dbArticle.setContent(requestDto.content());
        dbArticle.setCategory(CategoryResponseDto.toEntity(categoryService.findById(requestDto.categoryId())));
        dbArticle.setMember(memberService.findById(requestDto.memberId()));
        final var tags = tagService.findAll();
        final var tagsList = tags.stream().map(TagResponseDto::toEntity).toList();
        dbArticle.setTags(tagsList);
        articleRepository.save(dbArticle);
    }

    @Override
    public void deleteById(long id) {
        articleRepository.deleteById(id);
    }
}
