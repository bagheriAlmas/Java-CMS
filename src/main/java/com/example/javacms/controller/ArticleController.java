package com.example.javacms.controller;

import com.example.javacms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
}
