package com.example.emtlab1.service.impl;

import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.dto.BookDto;
import com.example.emtlab1.reoository.BookRepository;
import com.example.emtlab1.service.AuthorService;
import com.example.emtlab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto book) {
        if (book.getAuthor() != null &&
                authorService.findById(book.getAuthor()).isPresent()) {
                    return Optional.of(
                            bookRepository.save(new Book(book.getName(), book.getCategory(),
                            authorService.findById(book.getAuthor()).get(), book.getAvailableCopies()
                            )));
        }
        return Optional.empty();

    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookDto book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if(book.getName() != null){
                        existingBook.setName(book.getName());
                    }
                    if(book.getCategory() != null){
                        existingBook.setCategory(book.getCategory());
                    }
                    if(book.getAuthor() != null && authorService.findById(book.getAuthor()).isPresent()){
                        existingBook.setAuthor(authorService.findById(book.getAuthor()).get());
                    }
                    if(book.getAvailableCopies() != null){
                        existingBook.setAvailableCopies(book.getAvailableCopies());
                    }
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


}
