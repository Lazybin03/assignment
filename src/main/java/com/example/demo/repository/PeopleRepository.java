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
public interface PeopleRepository extends JpaRepository<Person, Long> {
    public List<Person> findByFamilyId(long id);

    public List<Person> findByFamilyIdAndUnivId(long familyId, long univId);

    @Query(value = "select p.univId , sum(p.power) as totalPower from Person p where p.familyId=:id group by p.univId")
    public List<Object[]>findFamilyPowerOfAllUniverses(@Param("id") long id);

    @Modifying
    @Query(value = "update Person p set p.power=:power where p.id=:id")
    public void updatePower(@Param("id") long id, @Param("power") int power);

    @Modifying
    @Query(value = "update Person p set p.univId=:univId where p.id=:id")
    public void updateUniverse(@Param("id") long id, @Param("univId") long univId);



}
