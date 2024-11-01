package com.example.libraryapp.mappers;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookDto toDto(Book book);
    List<BookDto> toDtoList(List<Book> books);
    Book toEntity(BookDto bookDto);
    @Mapping(target = "id", ignore = true)
    void updateBookFromDto(BookDto bookDto, @MappingTarget Book book);
}
