package com.example.libraryapp.advice;

import com.example.libraryapp.controllers.BookController;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import com.example.libraryapp.services.LocalizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.UnexpectedException;

@RestControllerAdvice(assignableTypes = BookController.class)
@Slf4j
@RequiredArgsConstructor
public class BookControllerAdvice {

    private final LocalizationService localizationService;

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
        log.error("The book could not be found", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(localizationService.getMessage(e.getMessage()));
    }
    @ExceptionHandler(BookNotCreatedException.class)
    public ResponseEntity<String> handleBookNotCreatedException(BookNotCreatedException e) {
        log.error("The book could not be created", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(localizationService.getMessage(e.getMessage()));
    }

    @ExceptionHandler(BookNotDeletedException.class)
    public ResponseEntity<String> handleBookNotDeletedException(BookNotDeletedException e) {
        log.error("The book could not be deleted", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(localizationService.getMessage(e.getMessage()));
    }

    @ExceptionHandler(BookNotUpdatedException.class)
    public ResponseEntity<String> handleBookNotUpdatedException(BookNotUpdatedException e) {
        log.error("The book could not be updated", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(localizationService.getMessage(e.getMessage()));
    }

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<String> handleUnexpectedException(UnexpectedException e) {
        log.error("An unexpected exception has occurred", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(localizationService.getMessage(e.getMessage()));
    }
}
