package com.example.javacms.controller;

import com.example.javacms.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tag")
@RequiredArgsConstructor
public class TagController{
    private final TagService tagService;
}
