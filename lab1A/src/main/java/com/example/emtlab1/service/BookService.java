package com.example.emtlab1.service;

import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> save(BookDto book);
    Optional<Book> findById(Long id);
    Optional<Book> update(Long id, BookDto book);
    void deleteById(Long id);

}
