package com.example.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "universes", indexes = {@Index(name = "id", unique = true, columnList = "id")})

public class Universe {
    @Id
    private String id;
    @NotBlank
    private String univName;
    private String univDescription;

    public Universe(String id, @NotBlank String univName, String univDescription) {
        this.id = id;
        this.univName = univName;
        this.univDescription = univDescription;
    }

    public Universe() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getUnivDescription() {
        return univDescription;
    }

    public void setUnivDescription(String univDescription) {
        this.univDescription = univDescription;
    }


}