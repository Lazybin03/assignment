package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "people", indexes = {@Index(name = "peopleID", unique = true, columnList = "id"),
        @Index(name = "familyId", columnList = "familyId")})

public class Person {
    @Id
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private int power;
    @NotNull
    private Long univId;
    @NotNull
    private Long familyId;

    public Person(@NotNull Long id, @NotBlank String name, @NotNull int power, @NotNull Long univId, @NotNull Long familyId) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.univId = univId;
        this.familyId = familyId;
    }

    public Person() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnivId() {
        return univId;
    }

    public void setUnivId(Long univId) {
        this.univId = univId;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


}