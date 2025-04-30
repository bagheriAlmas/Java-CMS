package com.example.javacms.controller;

import com.example.javacms.entity.dto.CommentRequestDto;
import com.example.javacms.entity.dto.CommentResponseDto;
import com.example.javacms.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    ResponseEntity<List<CommentResponseDto>> getAllComments() {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<CommentResponseDto> getCommentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertComment(@RequestBody @Valid CommentRequestDto requestDto) {
        commentService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateComment(@PathVariable("id") Long id, @RequestBody @Valid CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
