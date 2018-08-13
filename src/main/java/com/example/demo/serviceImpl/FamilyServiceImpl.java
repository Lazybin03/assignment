package com.example.demo.serviceImpl;

import com.example.demo.model.Family;
import com.example.demo.model.FamilyResquestDto;
import com.example.demo.utills.PersonIdGenerator;
import com.example.demo.model.UnivFamily;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.UnivFamilyRepository;
import com.example.demo.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private UnivFamilyRepository univFamilyRepository;

    @Transactional
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @Transactional
    public Optional<Family> findFamilyById(String id) {
        return familyRepository.findById(id);
    }

    @Transactional
    public Family createFamily(FamilyResquestDto familyResquestDto) {
        Family family = new Family();
        UnivFamily univFamily = new UnivFamily();
        family.setName(familyResquestDto.getName());
        family.setDescription(familyResquestDto.getDescription());
        family.setId(PersonIdGenerator.getId());
        family = familyRepository.save(family);
        univFamily.setUniverseId(familyResquestDto.getUnivId());
        univFamily.setFamilyId(family.getId());
        univFamily.setId(family.getId() + familyResquestDto.getUnivId());
        univFamilyRepository.save(univFamily);
        return familyRepository.save(family);
    }

    @Transactional
    public void deleteFamilyById(String id) {
        univFamilyRepository.deleteAllByFamilyId(id);
        familyRepository.deleteById(id);
    }
}
