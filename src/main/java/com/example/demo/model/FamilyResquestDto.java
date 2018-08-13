package com.example.demo.model;

public class FamilyResquestDto {
    private String name;
    private String description;
    private String univId;

    public FamilyResquestDto(String name, String description, String univId) {
        this.name = name;
        this.description = description;
        this.univId = univId;
    }

    public FamilyResquestDto() {
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

    public String getUnivId() {
        return univId;
    }

    public void setUnivId(String univId) {
        this.univId = univId;
    }
}
