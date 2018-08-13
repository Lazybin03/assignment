package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface PeopleRepository extends JpaRepository<Person, String> {
    public List<Person> findByFamilyId(String id);

    public List<Person> findByFamilyIdAndUnivId(String familyId, String univId);

    @Query(value = "select p.univId , sum(p.power) as totalPower from Person p where p.familyId=:id group by p.univId")
    public List<Object[]> findFamilyPowerOfAllUniverses(@Param("id") String id);

    @Modifying
    @Query(value = "update Person p set p.power=:power where p.id=:id")
    public void updatePower(@Param("id") String id, @Param("power") String power);

    @Modifying
    @Query(value = "update Person p set p.univId=:univId where p.id=:id")
    public void updateUniverse(@Param("id") String id, @Param("univId") String univId);


}
