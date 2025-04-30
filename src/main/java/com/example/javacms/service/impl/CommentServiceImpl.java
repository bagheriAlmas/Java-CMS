package com.example.javacms.service.impl;

import com.example.javacms.common.exceptions.CommentNotFoundException;
import com.example.javacms.entity.Comment;
import com.example.javacms.entity.dto.ArticleResponseDto;
import com.example.javacms.entity.dto.CommentRequestDto;
import com.example.javacms.entity.dto.CommentResponseDto;
import com.example.javacms.repository.CommentRepository;
import com.example.javacms.service.ArticleService;
import com.example.javacms.service.CommentService;
import com.example.javacms.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ArticleService articleService;
    private final MemberService memberService;

    @Override
    public List<CommentResponseDto> findAll() {
        final var commentList = commentRepository.findAll();
        return commentList.stream().map(Comment::toDto).toList();
    }

    @Override
    public CommentResponseDto findById(long id) {
        final var comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        return Comment.toDto(comment);
    }

    @Override
    public void save(CommentRequestDto requestDto) {
        final var article = articleService.findById(requestDto.articleId());
        final var member = memberService.findById(requestDto.memberId());
        final var comment = Comment.fromDto(requestDto, ArticleResponseDto.toEntity(article), member);
        commentRepository.save(comment);
    }

    @Override
    public void update(long id, CommentRequestDto requestDto) {
        final var dbComment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        dbComment.setContent(requestDto.content());
        dbComment.setArticle(ArticleResponseDto.toEntity(articleService.findById(requestDto.articleId())));
        dbComment.setMember(memberService.findById(requestDto.memberId()));
        commentRepository.save(dbComment);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}
