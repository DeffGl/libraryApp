package com.example.libraryapp.messages.listeners.impl;

import com.example.libraryapp.messages.listeners.ErrorListener;
import com.example.libraryapp.services.LocalizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ErrorListenerImpl implements ErrorListener {

    private final LocalizationService localizationService;

    @RabbitListener(queues = "error_queue")
    @Override
    public void handleError(String errorMessage) {
        log.error(localizationService.getMessage("error.receive.message", errorMessage));
    }
}