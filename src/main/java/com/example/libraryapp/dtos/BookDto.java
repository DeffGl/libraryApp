package com.example.libraryapp.dtos;

import java.time.LocalDateTime;

public record BookDto(String title, String author, LocalDateTime publishedDate) {
}
