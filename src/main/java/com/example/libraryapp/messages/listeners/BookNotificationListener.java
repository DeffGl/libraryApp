package com.example.libraryapp.messages.listeners;

import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import com.example.libraryapp.messages.events.BookEventDto;

public interface BookNotificationListener {

    void handleBookCreation(BookEventDto bookEventDto) throws BookNotCreatedException;

    void handleBookUpdate(BookEventDto bookEventDto) throws BookNotFoundException, BookNotUpdatedException;

    void handleBookDeletion(BookEventDto bookEventDto) throws BookNotFoundException, BookNotDeletedException;
}