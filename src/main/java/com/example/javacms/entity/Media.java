package com.example.javacms.entity;
import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.MediaRequestDto;
import com.example.javacms.entity.dto.MediaResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity(name = "Media")
@Table(name = "MEDIA")
@Accessors(chain = true)
@SequenceGenerator(name = "SEQ_MEDIA", sequenceName = "SeqMedia", allocationSize = 1)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Media extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SeqMedia")
    private Long id;


    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static Media fromDto(MediaRequestDto dto, Article article, Member member) {
        final var media = new Media();
        media.setUrl(dto.url());
        media.setArticle(article);
        media.setMember(member);
        return media;
    }

    public static MediaResponseDto toDto(Media media) {
        return new MediaResponseDto(media.getId(), media.getUrl(), media.getArticle(), media.getMember());
    }
}
