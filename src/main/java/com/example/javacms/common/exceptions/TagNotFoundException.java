package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TagNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public TagNotFoundException() {
        super("tag.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}