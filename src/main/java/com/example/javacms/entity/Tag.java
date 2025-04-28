package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Tag")
@Table(name = "TAG")
@Accessors(chain = true)
@Getter
@Setter
public class Tag extends BaseEntity implements Serializable {
    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles;
}
