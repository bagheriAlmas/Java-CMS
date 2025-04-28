package com.example.javacms.controller;

import com.example.javacms.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
}
