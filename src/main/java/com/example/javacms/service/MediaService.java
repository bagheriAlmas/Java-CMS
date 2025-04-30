package com.example.javacms.service;

import com.example.javacms.entity.Media;
import com.example.javacms.entity.dto.MediaRequestDto;
import com.example.javacms.entity.dto.MediaResponseDto;

import java.util.List;

public interface MediaService {
    List<MediaResponseDto> findAll();

    MediaResponseDto findById(long id);

    void save(MediaRequestDto requestDto);

    void update(long id, MediaRequestDto requestDto);

    void deleteById(long id);
}
