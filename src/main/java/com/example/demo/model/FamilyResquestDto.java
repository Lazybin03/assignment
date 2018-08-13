package com.example.demo.model;

public class FamilyResquestDto {
    private long id;
    private String name;
    private String description;
    private long univId;

    public FamilyResquestDto(long id, String name, String description, long univId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.univId = univId;
    }

    public FamilyResquestDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getUnivId() {
        return univId;
    }

    public void setUnivId(long univId) {
        this.univId = univId;
    }
}
