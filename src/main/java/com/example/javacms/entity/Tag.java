package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.TagRequestDto;
import com.example.javacms.entity.dto.TagResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Tags")
@Table(name = "TAGS")
@SequenceGenerator(name = "SEQ_TAG", sequenceName = "SeqTag", allocationSize = 1)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqTag")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles;

    public static Tag fromDto(TagRequestDto dto) {
        final var tag = new Tag();
        tag.setName(dto.name());
        return tag;
    }

    public static TagResponseDto toDto(Tag tag) {
        return new TagResponseDto(tag.getId(), tag.getName());
    }
}
