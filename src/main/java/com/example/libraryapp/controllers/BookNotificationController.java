package com.example.libraryapp.controllers;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.messages.senders.BookNotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/books")
@RequiredArgsConstructor
@Slf4j
public class BookNotificationController {
    private final BookNotificationSender bookNotificationSender;

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        bookNotificationSender.sendCreateNotification(bookDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookNotificationSender.sendUpdateNotification(id, bookDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookNotificationSender.sendDeleteNotification(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}