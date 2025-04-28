package com.example.javacms.controller;
import com.example.javacms.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/media")
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;
}
