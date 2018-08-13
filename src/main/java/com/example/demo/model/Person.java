package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "people", indexes = {@Index(name = "peopleID", unique = true, columnList = "id"),
        @Index(name = "familyId", columnList = "familyId")})

public class Person {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private int power;
    @NotNull
    private String univId;
    @NotNull
    private String familyId;

    public Person(String id, @NotBlank String name, @NotNull int power, @NotNull String univId, @NotNull String familyId) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.univId = univId;
        this.familyId = familyId;
    }

    public Person() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnivId() {
        return univId;
    }

    public void setUnivId(String univId) {
        this.univId = univId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getId() {
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