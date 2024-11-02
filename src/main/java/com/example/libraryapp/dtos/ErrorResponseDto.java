package com.example.libraryapp.dtos;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(LocalDateTime timestamp, Integer status, String error, String path) {
    public static ErrorResponseDto createErrorResponseDto(HttpStatus status, String message, String path) {
        return new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                message,
                path
        );
    }
}
