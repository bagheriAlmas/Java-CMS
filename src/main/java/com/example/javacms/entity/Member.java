package com.example.javacms.entity;

import com.example.javacms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Members")
@Table(name = "MEMBERS")
@Accessors(chain = true)
@SequenceGenerator(name = "SEQ_MEMBER", sequenceName = "SeqMember", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqMember")
    private Long id;

    @Column(name = "USERNAME", nullable = false, columnDefinition = "VARCHAR2(255)")
    private String username;

    @Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR2(255)")
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Article> articles;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
