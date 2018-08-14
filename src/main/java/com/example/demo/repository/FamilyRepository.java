package com.example.demo.repository;

import com.example.demo.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FamilyRepository extends JpaRepository<Family, String> {
    public Optional<Family> findById(String id);

    public List<Family> findByIdIn(Set<String> fids);

}
