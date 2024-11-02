package com.example.libraryapp.messages.handlers.impl;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import com.example.libraryapp.messages.handlers.BookEventHandler;
import com.example.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookEventHandlerImpl implements BookEventHandler {

    private final BookService bookService;

    @Override
    public void handleCreate(BookDto bookDto) throws BookNotCreatedException {
        bookService.createBook(bookDto);
    }

    @Override
    public void handleUpdate(Long id, BookDto bookDto) throws BookNotFoundException, BookNotUpdatedException {
        bookService.updateBook(id, bookDto);
    }

    @Override
    public void handleDelete(Long id) throws BookNotFoundException, BookNotDeletedException {
        bookService.deleteBook(id);
    }
}