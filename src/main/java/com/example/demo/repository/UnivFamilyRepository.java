package com.example.demo.repository;

import com.example.demo.model.UnivFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnivFamilyRepository extends JpaRepository<UnivFamily, String> {
    public List<UnivFamily> findByUniverseId(String id);

    public UnivFamily save(UnivFamily univFamily);

    @Query(value = "select U.familyId from UnivFamily U where U.universeId=:univId")
    public List<String> findByFamilyId(@Param("univId") String univId);

    public void deleteAllByFamilyId(String id);

    public void deleteAllByUniverseId(String id);

    @Query(value = "select U from UnivFamily U where U.familyId=:familyId and U.universeId=:univId")
    public UnivFamily findByFamilyIdAndUniverseId(@Param("familyId") String familyId, @Param("univId") String univId);

}
