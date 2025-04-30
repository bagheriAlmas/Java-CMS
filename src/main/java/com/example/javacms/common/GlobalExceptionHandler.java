package com.example.javacms.common;

import com.example.javacms.common.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(TagNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleTagNotFoundException(TagNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleRoleNotFoundException(RoleNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(MediaNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMediaNotFoundException(MediaNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCommentNotFoundException(CommentNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String lang = LocaleContextHolder.getLocale().getLanguage();
            String errorMessage = messageSource.getMessage(Objects.requireNonNull(error.getDefaultMessage()), null, new Locale(lang));
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleTagNotFoundException(HttpMessageNotReadableException exception) {
        final var response = createErrorMessage("web.notReadable", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTagNotFoundException(MethodArgumentTypeMismatchException exception) {
        final var response = createErrorMessage("web.method.parameter.notConverted", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> createErrorMessage(String messageCode, HttpStatus status) {
        String lang = LocaleContextHolder.getLocale().getLanguage();
        String message = messageSource.getMessage(messageCode, null, new Locale(lang));
        Map<String, Object> response = new HashMap<>();
        response.put("error_code", status.value());
        response.put("error_message", message);
        return response;
    }
}