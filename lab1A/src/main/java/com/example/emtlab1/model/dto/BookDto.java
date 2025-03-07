package com.example.emtlab1.model.dto;

import com.example.emtlab1.model.Author;
import com.example.emtlab1.model.enumerations.Category;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookDto {

    private Long Id;

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto(){

    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Long getAuthor() {
        return author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}


