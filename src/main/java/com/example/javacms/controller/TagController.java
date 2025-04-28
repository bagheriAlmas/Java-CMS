package com.example.javacms.controller;

import com.example.javacms.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tag")

public class TagController{

    @Autowired
    private TagService tagService;
}
