package com.example.javacms.repository;

import com.example.javacms.entity.Article;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
