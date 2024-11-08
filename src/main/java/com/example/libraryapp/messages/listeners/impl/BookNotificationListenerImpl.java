package com.example.libraryapp.messages.listeners.impl;

import com.example.libraryapp.constants.RabbitMQQueueConstants;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import com.example.libraryapp.messages.events.BookEventDto;
import com.example.libraryapp.messages.handlers.BookEventHandler;
import com.example.libraryapp.messages.listeners.BookNotificationListener;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookNotificationListenerImpl implements BookNotificationListener {

    private final BookEventHandler bookEventHandler;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQQueueConstants.BOOK_CREATE_QUEUE)
    @Override
    public void handleBookCreation(BookEventDto bookEventDto) {
        try {
            bookEventHandler.handleCreate(bookEventDto.bookDto());
        } catch (BookNotCreatedException e) {
            sendErrorToQueue(e.getMessage());
        }
    }

    @RabbitListener(queues = RabbitMQQueueConstants.BOOK_UPDATE_QUEUE)
    @Override
    public void handleBookUpdate(BookEventDto bookEventDto) {
        try {
            bookEventHandler.handleUpdate(bookEventDto.id(), bookEventDto.bookDto());
        } catch (BookNotFoundException | BookNotUpdatedException e) {
            sendErrorToQueue(e.getMessage());
        }
    }

    @RabbitListener(queues = RabbitMQQueueConstants.BOOK_DELETE_QUEUE)
    @Override
    public void handleBookDeletion(BookEventDto bookEventDto) {
        try {
            bookEventHandler.handleDelete(bookEventDto.id());
        } catch (BookNotFoundException | BookNotDeletedException e) {
            sendErrorToQueue(e.getMessage());
        }
    }

    private void sendErrorToQueue(String errorMessage) {
        rabbitTemplate.convertAndSend(RabbitMQQueueConstants.ERROR_QUEUE, errorMessage);
    }
}