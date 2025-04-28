package com.example.javacms.entity;
import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity(name = "Comment")
@Table(name = "COMMENT")
@Accessors(chain = true)
@Getter
@Setter
public class Comment extends BaseEntity implements Serializable {
    @Column(name = "CONTENT", nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
