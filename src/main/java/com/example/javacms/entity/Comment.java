package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.CommentRequestDto;
import com.example.javacms.entity.dto.CommentResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity(name = "Comments")
@Table(name = "COMMENTS")
@SequenceGenerator(name = "SEQ_COMMENT", sequenceName = "SeqComment", allocationSize = 1)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqComment")
    private Long id;

    @Column(name = "CONTENT", nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static Comment fromDto(CommentRequestDto dto, Article article, Member member) {
        final var comment = new Comment();
        comment.setContent(dto.content());
        comment.setArticle(article);
        comment.setMember(member);
        return comment;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.content, comment.getArticle().getId(), comment.getMember().getId());
    }
}
