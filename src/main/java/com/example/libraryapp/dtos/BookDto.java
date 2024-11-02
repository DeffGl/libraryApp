package com.example.libraryapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookDto(String title, String author, LocalDateTime publishedDate) {
}
