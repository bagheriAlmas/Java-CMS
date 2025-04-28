package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Category")
@Table(name = "CATEGORY")
@Accessors(chain = true)
@Getter
@Setter
public class Category extends BaseEntity implements Serializable {
    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
