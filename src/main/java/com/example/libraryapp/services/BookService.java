package com.example.libraryapp.services;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks() throws RuntimeException;
    BookDto getBookById(Long id) throws BookNotFoundException, RuntimeException;
    BookDto createBook(BookDto bookDto) throws BookNotCreatedException;
    BookDto updateBook(Long id, BookDto bookDto) throws BookNotUpdatedException, BookNotFoundException;
    void deleteBook(Long id) throws BookNotFoundException, BookNotDeletedException;
}
