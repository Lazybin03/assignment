package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "families", indexes = {@Index(name = "id", unique = true, columnList = "id")})
public class Family {
    @Id
    private String id;
    @NotBlank
    private String name;
    private String description;

    public Family(String id, @NotBlank String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Family() {
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}