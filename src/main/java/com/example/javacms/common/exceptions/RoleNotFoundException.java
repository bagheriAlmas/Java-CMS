package com.example.javacms.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RoleNotFoundException extends RuntimeException {
    private final HttpStatus status;

    public RoleNotFoundException() {
        super("role.notfound");
        this.status = HttpStatus.NOT_FOUND;
    }
}