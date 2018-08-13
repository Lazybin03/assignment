package com.example.demo.repository;

import com.example.demo.model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends JpaRepository<Universe, Long> {
}