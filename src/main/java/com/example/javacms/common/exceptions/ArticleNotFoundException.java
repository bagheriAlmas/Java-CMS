package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ArticleNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public ArticleNotFoundException() {
        super("article.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}