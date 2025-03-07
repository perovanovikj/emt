package com.example.emtlab1.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

    public Author(){

    }
    public Author( String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
