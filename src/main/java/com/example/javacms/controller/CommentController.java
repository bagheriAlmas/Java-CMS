package com.example.javacms.controller;

import com.example.javacms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private  CommentService commentService;
}
