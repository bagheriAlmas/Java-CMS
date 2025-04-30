package com.example.javacms.controller;

import com.example.javacms.entity.dto.TagRequestDto;
import com.example.javacms.entity.dto.TagResponseDto;
import com.example.javacms.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
@RequiredArgsConstructor
public class TagController{
    private final TagService tagService;

    @GetMapping
    ResponseEntity<List<TagResponseDto>> getAllTags() {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<TagResponseDto> getTagById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertTag(@RequestBody TagRequestDto requestDto) {
        tagService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateTag(@PathVariable("id") Long id, @RequestBody TagRequestDto requestDto) {
        tagService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteTag(@PathVariable("id") Long id) {
        tagService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
