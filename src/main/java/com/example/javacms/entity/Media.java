package com.example.javacms.entity;
import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity(name = "Media")
@Table(name = "MEDIA")
@Accessors(chain = true)
@Getter
@Setter
public class Media extends BaseEntity implements Serializable {
    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
