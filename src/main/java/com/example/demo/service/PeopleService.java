package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    public List<Person> getAllPeople();

    public Optional<Person> findPeopleById(long id);

    public Person createPerson(Person person);

    public void deletePersonById(long id);

}
