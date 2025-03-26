package com.example.lab1b.service.impl;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.dto.CreateAccomodationDto;
import com.example.lab1b.repository.AccomodationRepository;
import com.example.lab1b.service.AccomodationService;
import com.example.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccomodationServiceImpl implements AccomodationService {
    private final AccomodationRepository accomodationRepository;
    private final HostService hostService;

    public AccomodationServiceImpl(AccomodationRepository accomodationRepository, HostService hostService) {
        this.accomodationRepository = accomodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accomodation> findAll() {
        return this.accomodationRepository.findAll();
    }

    @Override
    public Optional<Accomodation> findById(Long id) {
        return accomodationRepository.findById(id);
    }

    @Override
    public Optional<Accomodation> save(CreateAccomodationDto accomodation) {
        if(accomodation.getHost() != null &&
            hostService.findById(accomodation.getHost()).isPresent()) {
            return Optional.of(
                    accomodationRepository.save(new Accomodation(accomodation.getName(), accomodation.getCategory(),
                            hostService.findById(accomodation.getHost()).get(), accomodation.getNumRooms()))
            );}

            return Optional.empty();
        }

    @Override
    public Optional<Accomodation> update(Long id, CreateAccomodationDto accomodation) {
        return accomodationRepository.findById(id)
                .map(ea -> {
                    if (accomodation.getName() != null) ea.setName(accomodation.getName());
                    if (accomodation.getCategory() != null) ea.setCategory(accomodation.getCategory());
                    if (accomodation.getNumRooms() != null) ea.setNumRooms(accomodation.getNumRooms());
                    if (accomodation.getHost() != null && hostService.findById(accomodation.getHost()).isPresent())
                        ea.setHost(hostService.findById(accomodation.getHost()).get());
                    return accomodationRepository.save(ea);
                });
    }

    @Override
    public void deleteById(Long id) {
        accomodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accomodation> rent(Long id) {
        accomodationRepository.findById(id).get().setRented(true);
        return Optional.of(accomodationRepository.findById(id).get());
    }


}

