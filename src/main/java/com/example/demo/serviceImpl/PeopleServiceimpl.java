package com.example.demo.serviceImpl;

import com.example.demo.model.Person;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceimpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Transactional
    public Optional<Person> findPeopleById(long id) {
        return peopleRepository.findById(id);
    }

    @Transactional
    public Person createPerson(Person person) {
        return peopleRepository.save(person);
    }

    @Transactional
    public void deletePersonById(long id) {
        peopleRepository.deleteById(id);
    }

}
