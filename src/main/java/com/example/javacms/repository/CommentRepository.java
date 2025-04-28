package com.example.javacms.repository;

import com.example.javacms.entity.Comment;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
