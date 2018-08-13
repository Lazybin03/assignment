package com.example.demo.repository;

import com.example.demo.model.UnivFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface UnivFamilyRepository extends JpaRepository<UnivFamily, String> {
    public List<UnivFamily> findByUniverseId(String id);

    public List<UnivFamily> findByFamilyId(String id);

    public void deleteAllByFamilyId(String id);
}
