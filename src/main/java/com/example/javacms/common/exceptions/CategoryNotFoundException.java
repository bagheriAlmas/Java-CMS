package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CategoryNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public CategoryNotFoundException() {
        super("category.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}