package com.example.libraryapp.messages.handlers;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;

public interface BookEventHandler {
    void handleCreate(BookDto bookDto) throws BookNotCreatedException;

    void handleUpdate(Long id, BookDto bookDto) throws BookNotFoundException, BookNotUpdatedException;

    void handleDelete(Long id) throws BookNotFoundException, BookNotDeletedException;
}