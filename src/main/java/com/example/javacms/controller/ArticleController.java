package com.example.javacms.controller;

import com.example.javacms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
}
