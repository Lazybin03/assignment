package com.example.demo.serviceImpl;

import com.example.demo.model.Family;
import com.example.demo.model.Person;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.UnivFamilyRepository;
import com.example.demo.repository.UniverseRepository;
import com.example.demo.service.PeopleService;
import com.example.demo.utills.PersonIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceimpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private UniverseRepository universeRepository;
    @Autowired
    private UnivFamilyRepository univFamilyRepository;

    @Transactional
    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Transactional
    public Optional<Person> findPeopleById(String id) {
        return peopleRepository.findById(id);
    }

    @Transactional
    public Person createPerson(Person person) {
        person.setId(PersonIdGenerator.getId());
        try {
            person.setFamilyId(familyRepository.findById(person.getFamilyId()).get().getId());
            person.setUnivId(universeRepository.findById(person.getUnivId()).get().getId());
            if (univFamilyRepository.findByFamilyIdAndUniverseId(person.getFamilyId(), person.getUnivId()) != null) {
                return peopleRepository.save(person);
            } else return null;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Transactional
    public void deletePersonById(String id) {
        peopleRepository.deleteById(id);
    }

}
