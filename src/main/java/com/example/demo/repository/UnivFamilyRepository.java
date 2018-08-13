package com.example.demo.repository;

import com.example.demo.model.UnivFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface UnivFamilyRepository extends JpaRepository<UnivFamily, Long> {
    public List<UnivFamily> findByUniverseId(long id);

    public List<UnivFamily> findByFamilyId(long id);

    public void deleteAllByFamilyId(long id);
}
