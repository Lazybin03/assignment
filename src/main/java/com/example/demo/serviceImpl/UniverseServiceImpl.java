package com.example.demo.serviceImpl;

import com.example.demo.model.Universe;
import com.example.demo.repository.UniverseRepository;
import com.example.demo.service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniverseServiceImpl implements UniverseService {

    @Autowired
    private UniverseRepository universeRepository;


    @Transactional
    public Universe createUnivrese(Universe universe) {
        return universeRepository.save(universe);
    }

    @Transactional
    public void deleteUniverse(long id) {
        universeRepository.deleteById(id);

    }

    @Transactional
    public Optional<Universe> findUnivreseById(long id) {
        return universeRepository.findById(id);
    }

    @Transactional
    public List<Universe> getAllUniverse() {
        return universeRepository.findAll();
    }
}
