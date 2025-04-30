package com.example.javacms.controller;

import com.example.javacms.entity.dto.ArticleRequestDto;
import com.example.javacms.entity.dto.ArticleResponseDto;
import com.example.javacms.service.ArticleService;
import com.example.javacms.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    ResponseEntity<List<ArticleResponseDto>> getAllArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<ArticleResponseDto> getArticleById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertArticle(@RequestBody @Valid ArticleRequestDto requestDto) {
        articleService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateArticle(@PathVariable("id") Long id, @RequestBody @Valid ArticleRequestDto requestDto) {
        articleService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
