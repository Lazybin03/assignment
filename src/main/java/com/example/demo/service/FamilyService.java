package com.example.demo.service;

import com.example.demo.model.Family;
import com.example.demo.model.FamilyResquestDto;


import java.util.List;
import java.util.Optional;


public interface FamilyService {
    public List<Family> getAllFamilies();

    public Optional<Family> findFamilyById(String id);

    public Family createFamily(Family family);

    public void deleteFamilyById(String id);

    public Family createFamilyNAddToUniverse(FamilyResquestDto familyResquestDto);


}
