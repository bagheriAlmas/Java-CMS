package com.example.javacms.service;

import com.example.javacms.entity.Comment;
import com.example.javacms.entity.dto.CommentRequestDto;
import com.example.javacms.entity.dto.CommentResponseDto;

import java.util.List;

public interface CommentService {
    List<CommentResponseDto> findAll();

    CommentResponseDto findById(long id);

    void save(CommentRequestDto requestDto);

    void update(long id, CommentRequestDto requestDto);

    void deleteById(long id);
}
