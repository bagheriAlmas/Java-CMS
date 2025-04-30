package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import com.example.javacms.entity.dto.RoleRequestDto;
import com.example.javacms.entity.dto.RoleResponseDto;
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

@Entity(name = "Roles")
@Table(name = "ROLES")
@SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SeqRole", allocationSize = 1)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqRole")
    private Long id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<Member> members;

    public static Role fromDto(RoleRequestDto dto) {
        final var role = new Role();
        role.setRoleName(dto.roleName());
        return role;
    }

    public static RoleResponseDto toDto(Role role) {
        return new RoleResponseDto(role.getId(), role.getRoleName());
    }
}
