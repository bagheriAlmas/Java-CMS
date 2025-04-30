package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.ArticleRequestDto;
import com.example.javacms.entity.dto.ArticleResponseDto;
import com.example.javacms.entity.dto.MediaRequestDto;
import com.example.javacms.entity.dto.MediaResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Articles")
@Table(name = "ARTICLES")
@SequenceGenerator(name = "SEQ_ARTICLE", sequenceName = "SeqArticle", allocationSize = 1)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqArticle")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false, length = 4000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany
    @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public static Article fromDto(ArticleRequestDto dto, Category category, Member member, List<Tag> tags) {
        final var article = new Article();
        article.setTitle(dto.title());
        article.setContent(dto.content());
        article.setCategory(category);
        article.setMember(member);
        article.setTags(tags);
        return article;
    }

    public static ArticleResponseDto toDto(Article article) {
        return new ArticleResponseDto(article.getId(), article.getTitle(), article.getContent(), article.getCategory(), article.getMember(), article.getTags());
    }

}
