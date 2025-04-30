package com.example.javacms.common;

import com.example.javacms.common.exceptions.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        final var response = createErrorMessage(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(response, exception.getStatus());
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