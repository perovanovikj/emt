package com.example.emtlab1.config;


import com.example.emtlab1.model.Author;
import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.Country;
import com.example.emtlab1.reoository.AuthorRepository;
import com.example.emtlab1.reoository.BookRepository;
import com.example.emtlab1.reoository.CountryRepository;
import com.example.emtlab1.model.enumerations.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

   private final BookRepository bookRepository;
   private final AuthorRepository authorRepository;
   private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country("USA", "North America");
        Country country2 = new Country("Germany", "Europe");
        Country country3 = new Country("India", "Asia");
        Country country4 = new Country("Brazil", "South America");
        Country country5 = new Country("Australia", "Oceania");

        countryRepository.saveAll(List.of(country1, country2, country3, country4, country5));

        // Create and save Authors
        Author author1 = new Author("John", "Doe", country1);
        Author author2 = new Author("Jane", "Smith", country2);
        Author author3 = new Author("Amit", "Sharma", country3);
        Author author4 = new Author("Carlos", "Mendes", country4);
        Author author5 = new Author("Zara", "Miller", country5);

        authorRepository.saveAll(List.of(author1, author2, author3, author4, author5));

        // Create and save Books
        Book book1 = new Book("Java Basics", Category.NOVEL, author1, 10);
        Book book2 = new Book("Spring Framework", Category.FANTASY, author2, 8);
        Book book3 = new Book("Learn SQL", Category.FANTASY, author3, 15);
        Book book4 = new Book("Machine Learning 101", Category.DRAMA, author4, 5);
        Book book5 = new Book("Web Development", Category.FANTASY, author5, 20);
        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5));
    }

}
