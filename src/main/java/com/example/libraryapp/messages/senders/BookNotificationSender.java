package com.example.libraryapp.messages.senders;

import com.example.libraryapp.dtos.BookDto;

public interface BookNotificationSender {
    void sendCreateNotification(BookDto bookDto);

    void sendUpdateNotification(Long id, BookDto bookDto);

    void sendDeleteNotification(Long id);
}
