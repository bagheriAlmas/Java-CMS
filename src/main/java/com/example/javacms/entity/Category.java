package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.CategoryRequestDto;
import com.example.javacms.entity.dto.CategoryResponseDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Categories")
@Table(name = "CATEGORIES")
@SequenceGenerator(name = "SEQ_CATEGORY", sequenceName = "SeqCategory", allocationSize = 1)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Category extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqCategory")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    public static Category fromDto(CategoryRequestDto dto) {
        final var category = new Category();
        category.setName(dto.name());
        return category;
    }

    public static CategoryResponseDto toDto(Category category) {
        return new CategoryResponseDto(category.getId(), category.getName());
    }
}
