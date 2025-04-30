package com.example.javacms.service;

import com.example.javacms.entity.dto.TagRequestDto;
import com.example.javacms.entity.dto.TagResponseDto;

import java.util.List;

public interface TagService {
    List<TagResponseDto> findAll();

    TagResponseDto findById(long id);

    void save(TagRequestDto requestDto);

    void update(long id, TagRequestDto requestDto);

    void deleteById(long id);
}
