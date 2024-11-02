package com.example.libraryapp.messages.senders.impl;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.messages.events.BookEventDto;
import com.example.libraryapp.messages.senders.BookNotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookNotificationSenderImpl implements BookNotificationSender {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendCreateNotification(BookDto bookDto) {
        BookEventDto bookEventDto = new BookEventDto(null, bookDto);
        sendNotification("book_create_queue", bookEventDto);
    }

    @Override
    public void sendUpdateNotification(Long id, BookDto bookDto) {
        BookEventDto bookEventDto = new BookEventDto(id, bookDto);
        sendNotification("book_update_queue", bookEventDto);
    }

    @Override
    public void sendDeleteNotification(Long id) {
        BookEventDto bookEventDto = new BookEventDto(id, null);
        sendNotification("book_delete_queue", bookEventDto);
    }

    private void sendNotification(String routingKey, BookEventDto bookEventDto){
        rabbitTemplate.convertAndSend(routingKey, bookEventDto);
    }
}
