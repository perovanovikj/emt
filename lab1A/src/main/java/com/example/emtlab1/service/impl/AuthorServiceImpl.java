package com.example.emtlab1.service.impl;

import com.example.emtlab1.model.Author;
import com.example.emtlab1.reoository.AuthorRepository;
import com.example.emtlab1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
