package com.example.lab1b.service;

import com.example.lab1b.model.Host;

import java.util.Optional;

public interface HostService {
    Optional<Host> findById(Long id);
}
