package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommentNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public CommentNotFoundException() {
        super("comment.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}