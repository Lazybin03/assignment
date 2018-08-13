package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PeopleService;
import com.example.demo.utills.CustomResponse;
import com.example.demo.utills.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/people")
public class PeopleRestApi {
    @Autowired
    PeopleService peopleService;

    @GetMapping("/all")
    public CustomResponse getAllPeople() {
        List<Person> personList = peopleService.getAllPeople();
        if (personList.size() != 0)
            return new CustomResponse("people", personList);
        else throw new ResourceNotFoundException("People", "There is people data in tha database");
    }


    @GetMapping("/{id}")
    public CustomResponse getPersonById(@PathVariable(value = "id") String id) {
        Optional<Person> person = peopleService.findPeopleById(id);
        if (person != null)
            return new CustomResponse("person", person);
        else throw new ResourceNotFoundException("People", "No person found with id:" + id);
    }

    @PostMapping("/person")
    public CustomResponse createPerson(@Valid @RequestBody Person person) {
        Person savedperson = peopleService.createPerson(person);
        if (savedperson != null) {
            return new CustomResponse("Success", savedperson);
        } else {
            return new CustomResponse("error", "failed to save the person");
        }
    }

    @DeleteMapping("/{id}")
    public CustomResponse deletePerson(@PathVariable(value = "id") String id) {
        try {
            peopleService.deletePersonById(id);
            return new CustomResponse("Success", "successfully deleted the person with id:" + id);
        } catch (Exception ex) {

        }

        return new CustomResponse("error", "failed to delete the person with id:" + id);
    }


}
