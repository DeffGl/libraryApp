package com.example.libraryapp.advice;

import com.example.libraryapp.controllers.BookController;
import com.example.libraryapp.dtos.ErrorResponseDto;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.UnexpectedException;

import static com.example.libraryapp.dtos.ErrorResponseDto.createErrorResponseDto;

@RestControllerAdvice(assignableTypes = BookController.class)
@Slf4j
@RequiredArgsConstructor
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request) {
        log.error("The book could not be found", e);
        ErrorResponseDto response = createErrorResponseDto(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(BookNotCreatedException.class)
    public ResponseEntity<ErrorResponseDto> handleBookNotCreatedException(BookNotCreatedException e, HttpServletRequest request) {
        log.error("The book could not be created", e);
        ErrorResponseDto response = createErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(BookNotDeletedException.class)
    public ResponseEntity<ErrorResponseDto> handleBookNotDeletedException(BookNotDeletedException e, HttpServletRequest request) {
        log.error("The book could not be deleted", e);
        ErrorResponseDto response = createErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(BookNotUpdatedException.class)
    public ResponseEntity<ErrorResponseDto> handleBookNotUpdatedException(BookNotUpdatedException e, HttpServletRequest request) {
        log.error("The book could not be updated", e);
        ErrorResponseDto response = createErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<ErrorResponseDto> handleUnexpectedException(UnexpectedException e, HttpServletRequest request) {
        log.error("An unexpected exception has occurred", e);
        ErrorResponseDto response = createErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
