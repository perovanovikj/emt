package com.example.emtlab1.service;

import com.example.emtlab1.model.Author;
import com.example.emtlab1.reoository.AuthorRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
}
