package com.example.lab1b.service.impl;

import com.example.lab1b.model.Host;
import com.example.lab1b.repository.HostRepository;
import com.example.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }
}
