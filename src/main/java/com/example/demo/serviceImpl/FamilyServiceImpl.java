package com.example.demo.serviceImpl;

import com.example.demo.model.Family;
import com.example.demo.model.FamilyResquestDto;
import com.example.demo.model.UnivFamily;
import com.example.demo.model.Universe;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.UniverseRepository;
import com.example.demo.utills.FamilyIdGenerator;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.UnivFamilyRepository;
import com.example.demo.service.FamilyService;
import com.example.demo.utills.UnivFamilyIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private UnivFamilyRepository univFamilyRepository;
    @Autowired
    private UniverseRepository universeRepository;
    @Autowired
    PeopleRepository peopleRepository;

    @Transactional
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @Transactional
    public Optional<Family> findFamilyById(String id) {
        return familyRepository.findById(id);
    }

    @Transactional
    public Family createFamily(Family familyResquestDto) {
        familyResquestDto.setId(FamilyIdGenerator.getId());
        return familyRepository.save(familyResquestDto);
    }

    @Transactional
    public void deleteFamilyById(String id) {
        peopleRepository.deleteAllByFamilyId(id);
        univFamilyRepository.deleteAllByFamilyId(id);
        familyRepository.deleteById(id);
    }

    @Transactional
    public Family createFamilyNAddToUniverse(FamilyResquestDto familyResquestDto) {
        Family family = new Family();
        try {
            List<Universe> universeList = universeRepository.findAll();
            Set<String> universeIdSet = new HashSet<>();
            for (Universe univ : universeList) {
                universeIdSet.add(univ.getId());
            }
            family.setId(FamilyIdGenerator.getId());
            family.setName(familyResquestDto.getName());
            family.setDescription(familyResquestDto.getDescription());
            family = familyRepository.save(family);
            List<String> ids = familyResquestDto.getUnivIds();
            List<UnivFamily> univFamilyList = new ArrayList<>();
            if (ids != null && ids.size() != 0) {
                for (String id : ids) {
                    if (universeIdSet.contains(id)) {
                        UnivFamily univFamily = new UnivFamily();
                        univFamily.setId(UnivFamilyIdGenerator.getId());
                        univFamily.setFamilyId(family.getId());
                        univFamily.setUniverseId(id);
                        univFamilyList.add(univFamily);
                    }
                }
                univFamilyRepository.saveAll(univFamilyList);
            }
            return family;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
