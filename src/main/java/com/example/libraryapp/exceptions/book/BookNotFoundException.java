package com.example.libraryapp.exceptions.book;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String message) {
        super(message);
    }
}
