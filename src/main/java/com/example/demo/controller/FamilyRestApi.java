package com.example.demo.controller;


import com.example.demo.model.Family;
import com.example.demo.model.FamilyResquestDto;
import com.example.demo.service.FamilyService;
import com.example.demo.utills.CustomResponse;
import com.example.demo.utills.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/families")
public class FamilyRestApi {
    @Autowired
    FamilyService familyService;

    @GetMapping("/all")
    public CustomResponse getAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        if (families.size() != 0)
            return new CustomResponse("families", families);
        else throw new ResourceNotFoundException("family", "There is people data in tha database");
    }

    @GetMapping("/{id}")
    public CustomResponse getFamilyById(@PathVariable(value = "id") String id) {
        Optional<Family> family = familyService.findFamilyById(id);
        if (family == null)
            throw new ResourceNotFoundException("family", "Not able to find any family with id:" + id);
        return new CustomResponse("family", family);
    }

    @PostMapping("/family")
    public CustomResponse createFamily(@Valid @RequestBody FamilyResquestDto family) {
        Family savedFamily = familyService.createFamily(family);
        if (savedFamily != null) {
            return new CustomResponse("Success", savedFamily);
        } else {
            return new CustomResponse("error", "failed to save family");
        }
    }

    @DeleteMapping("/{id}")
    public CustomResponse deleteNote(@PathVariable(value = "id") String id) {
        try {
            familyService.deleteFamilyById(id);
            return new CustomResponse("success", "successfully deleted with id:" + id);
        } catch (Exception ex) {

        }
        return new CustomResponse("error", "failed to delete family with id:" + id);
    }


}
