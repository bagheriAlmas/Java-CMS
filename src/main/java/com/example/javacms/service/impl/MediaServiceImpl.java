package com.example.javacms.service.impl;

import com.example.javacms.common.exceptions.MediaNotFoundException;
import com.example.javacms.entity.Media;
import com.example.javacms.entity.dto.MediaRequestDto;
import com.example.javacms.entity.dto.MediaResponseDto;
import com.example.javacms.repository.MediaRepository;
import com.example.javacms.service.ArticleService;
import com.example.javacms.service.MediaService;
import com.example.javacms.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final ArticleService articleService;
    private final MemberService memberService;

    @Override
    public List<MediaResponseDto> findAll() {
        final var mediaList = mediaRepository.findAll();
        return mediaList.stream().map(Media::toDto).toList();
    }

    @Override
    public MediaResponseDto findById(long id) {
        final var media = mediaRepository.findById(id).orElseThrow(MediaNotFoundException::new);
        return Media.toDto(media);
    }

    @Override
    public void save(MediaRequestDto requestDto) {
        final var article = articleService.findById(requestDto.articleId());
        final var member = memberService.findById(requestDto.memberId());
        final var media = Media.fromDto(requestDto, article, member);
        mediaRepository.save(media);
    }

    @Override
    public void update(long id, MediaRequestDto requestDto) {
        final var dbMedia = mediaRepository.findById(id).orElseThrow(MediaNotFoundException::new);
        dbMedia.setUrl(requestDto.url());
        dbMedia.setArticle(articleService.findById(requestDto.articleId()));
        dbMedia.setMember(memberService.findById(requestDto.memberId()));
        mediaRepository.save(dbMedia);
    }

    @Override
    public void deleteById(long id) {
        mediaRepository.deleteById(id);
    }
}
