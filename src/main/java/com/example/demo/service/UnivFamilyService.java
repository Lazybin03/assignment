package com.example.demo.service;

import com.example.demo.model.Family;
import com.example.demo.model.UnivFamily;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UnivFamilyService {
    public List<UnivFamily> getAll();

    public Optional<UnivFamily> findUnivFamilyById(long id);

    public UnivFamily createUniFamily(UnivFamily univFamily);

    public void deleteUnivFamilyById(long id);

    List<Optional<Family>> findFamiliesByUId(long id);

    List<Object[]> findFamilyPowerOfAllUniverses(Long id);

    boolean balanceFamily(Long id);
}
