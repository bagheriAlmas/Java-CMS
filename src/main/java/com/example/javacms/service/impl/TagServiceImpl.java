package com.example.javacms.service.impl;

import com.example.javacms.common.exceptions.TagNotFoundException;
import com.example.javacms.entity.Tag;
import com.example.javacms.entity.dto.TagRequestDto;
import com.example.javacms.entity.dto.TagResponseDto;
import com.example.javacms.repository.TagRepository;
import com.example.javacms.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    
    private final TagRepository tagRepository;

    @Override
    public List<TagResponseDto> findAll() {
        final var tagList = tagRepository.findAll();
        return tagList.stream().map(Tag::toDto).toList();
    }

    @Override
    public TagResponseDto findById(long id) {
        final var tag = tagRepository.findById(id).orElseThrow(TagNotFoundException::new);
        return Tag.toDto(tag);
    }

    @Override
    public void save(TagRequestDto requestDto) {
        final var tag = Tag.fromDto(requestDto);
        tagRepository.save(tag);
    }

    @Override
    public void update(long id, TagRequestDto requestDto) {
        final var dbTag = tagRepository.findById(id).orElseThrow(TagNotFoundException::new);
        dbTag.setName(requestDto.name());
        tagRepository.save(dbTag);
    }

    @Override
    public void deleteById(long id) {
        tagRepository.deleteById(id);
    }
}
