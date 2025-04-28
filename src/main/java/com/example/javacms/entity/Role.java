package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Role")
@Table(name = "ROLE")
@Accessors(chain = true)
@Getter
@Setter
public class Role extends BaseEntity implements Serializable {
    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
