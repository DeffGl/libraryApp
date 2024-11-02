package com.example.libraryapp.services;

public interface LocalizationService {
    String getMessage(String code);
    String getMessage(String code, Object... args);
}
