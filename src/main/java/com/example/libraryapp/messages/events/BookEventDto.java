package com.example.libraryapp.messages.events;

import com.example.libraryapp.dtos.BookDto;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookEventDto(Long id, BookDto bookDto) {
}