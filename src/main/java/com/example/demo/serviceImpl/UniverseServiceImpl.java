package com.example.demo.serviceImpl;

import com.example.demo.model.Universe;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.UnivFamilyRepository;
import com.example.demo.repository.UniverseRepository;
import com.example.demo.service.UniverseService;
import com.example.demo.utills.UniverseIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniverseServiceImpl implements UniverseService {

    @Autowired
    private UniverseRepository universeRepository;
    @Autowired
    UnivFamilyRepository univFamilyRepository;
    @Autowired
    PeopleRepository peopleRepository;


    @Transactional
    public Universe createUnivrese(Universe universe) {
        universe.setId(UniverseIdGenerator.getId());
        return universeRepository.save(universe);
    }

    @Transactional
    public void deleteUniverse(String id) {
        peopleRepository.deleteAllByUnivId(id);
        univFamilyRepository.deleteAllByUniverseId(id);
        universeRepository.deleteById(id);

    }

    @Transactional
    public Optional<Universe> findUnivreseById(String id) {
        return universeRepository.findById(id);
    }

    @Transactional
    public List<Universe> getAllUniverse() {
        return universeRepository.findAll();
    }
}
