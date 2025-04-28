package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "User")
@Table(name = "USER")
@Accessors(chain = true)
@Getter
@Setter
public class User extends BaseEntity implements Serializable {
    @Column(name = "USERNAME", nullable = false, columnDefinition = "VARCHAR2(255)")
    private String username;

    @Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR2(255)")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Article> articles;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
