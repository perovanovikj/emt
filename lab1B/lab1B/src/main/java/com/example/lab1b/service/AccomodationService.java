package com.example.lab1b.service;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.dto.CreateAccomodationDto;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {
    List<Accomodation> findAll();

    Optional<Accomodation> findById(Long id);
    Optional<Accomodation> save(CreateAccomodationDto createAccomodation);

    Optional<Accomodation> update(Long id, CreateAccomodationDto accomodation);

    void deleteById(Long id);

    Optional<Accomodation> rent(Long id);

}
