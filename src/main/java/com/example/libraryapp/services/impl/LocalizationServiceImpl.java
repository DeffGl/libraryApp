package com.example.libraryapp.services.impl;

import com.example.libraryapp.services.LocalizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocalizationServiceImpl implements LocalizationService {
    private final static String ERROR_MESSAGE = "The localized message could not be received by code: {}";

    private final MessageSource messageSource;
    @Override
    public String getMessage(String code) {
        try{
            return messageSource.getMessage(code, null, Locale.getDefault());
        } catch (Exception e){
            log.error(ERROR_MESSAGE, code);
        }
        return "";
    }

    @Override
    public String getMessage(String code, Object... args) {
        try {
            return messageSource.getMessage(code, args, Locale.getDefault());
        } catch (Exception e) {
            log.error(ERROR_MESSAGE, code);
        }
        return "";
    }
}