package com.example.demo.service;

import com.example.demo.model.UnivFamily;
import com.example.demo.model.Universe;

import java.util.List;
import java.util.Optional;

public interface UniverseService {
    public List<Universe> getAllUniverse();
    public Universe createUnivrese(Universe universe);

    public void deleteUniverse(String id);

    public Optional<Universe> findUnivreseById(String id);
}
