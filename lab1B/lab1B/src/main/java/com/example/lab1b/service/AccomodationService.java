package com.example.lab1b.service;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.model.dto.AccomodationDto;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {
    List<Accomodation> findAll();

    Optional<Accomodation> findById(Long id);
    Optional<Accomodation> save(AccomodationDto accomodation);

    Optional<Accomodation> update(Long id, AccomodationDto accomodation);

    void deleteById(Long id);

    Optional<Accomodation> rent(Long id);

}
