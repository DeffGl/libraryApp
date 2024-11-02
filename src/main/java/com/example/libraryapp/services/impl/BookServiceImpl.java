package com.example.libraryapp.services.impl;

import com.example.libraryapp.dtos.BookDto;
import com.example.libraryapp.entities.Book;
import com.example.libraryapp.exceptions.book.BookNotCreatedException;
import com.example.libraryapp.exceptions.book.BookNotDeletedException;
import com.example.libraryapp.exceptions.book.BookNotFoundException;
import com.example.libraryapp.exceptions.book.BookNotUpdatedException;
import com.example.libraryapp.mappers.BookMapper;
import com.example.libraryapp.repositories.BookRepository;
import com.example.libraryapp.services.BookService;
import com.example.libraryapp.services.LocalizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final LocalizationService localizationService;

    @Override
    public List<BookDto> getAllBooks() throws RuntimeException {
        try {
            log.debug("Receive all books");
            return bookMapper.toDtoList(bookRepository.findAll());
        } catch (Exception e){
            throw new RuntimeException(localizationService.getMessage("error.book.runtimeException"));
        }
    }

    @Override
    public BookDto getBookById(Long id) throws BookNotFoundException, RuntimeException {
        Book book = findBookById(id);
        try {
            return bookMapper.toDto(book);
        } catch (Exception e){
            throw new RuntimeException(localizationService.getMessage("error.book.runtimeException"));
        }
    }

    @Override
    @Transactional
    public BookDto createBook(BookDto bookDto) throws BookNotCreatedException{
        try {
            log.debug("Create book by bookDto: {}", bookDto);
            return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookDto)));
        } catch (Exception e) {
            throw new BookNotCreatedException(localizationService.getMessage("error.book.notCreated"));
        }
    }

    @Override
    @Transactional
    public BookDto updateBook(Long id, BookDto bookDto) throws BookNotUpdatedException, BookNotFoundException {
        Book book = findBookById(id);
        try {
            log.debug("Update book with id: {}, by bookDto: {}", id, bookDto);
            bookMapper.updateBookFromDto(bookDto, book);
            return bookMapper.toDto(bookRepository.save(book));
        } catch (Exception e) {
            throw new BookNotUpdatedException(localizationService.getMessage("error.book.notUpdated", id));
        }
    }

    @Override
    @Transactional
    public void deleteBook(Long id) throws BookNotFoundException, BookNotDeletedException {
        Book book = findBookById(id);
        try {
            log.debug("Delete book with id: {}", id);
            bookRepository.delete(book);
        } catch (Exception e) {
            throw new BookNotDeletedException(localizationService.getMessage("error.book.notDeleted", id));
        }
    }

    private Book findBookById(Long id) throws BookNotFoundException {
        log.debug("Receive book by id: {}", id);
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(localizationService.getMessage("error.book.notFound", id)));
    }
}
