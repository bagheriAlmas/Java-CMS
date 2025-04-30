package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MediaNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public MediaNotFoundException() {
        super("media.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}