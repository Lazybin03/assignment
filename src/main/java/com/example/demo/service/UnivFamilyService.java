package com.example.demo.service;

import com.example.demo.model.Family;
import com.example.demo.model.UnivFamily;

import java.util.List;

import java.util.Optional;

public interface UnivFamilyService {
    public List<UnivFamily> getAll();

    public Optional<UnivFamily> findUnivFamilyById(String id);

    public UnivFamily createUniFamily(UnivFamily univFamily);

    public void deleteUnivFamilyById(String id);

    List<Optional<Family>> findFamiliesByUId(String id);

    List<Object[]> findFamilyPowerOfAllUniverses(String id);

    boolean balanceFamily(String id);
}
