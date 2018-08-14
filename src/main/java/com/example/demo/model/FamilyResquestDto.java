package com.example.demo.model;

import java.util.List;

public class FamilyResquestDto {
    private String name;
    private String description;
    private List<String> univIds;

    public FamilyResquestDto(String name, String description, List<String> univIds) {
        this.name = name;
        this.description = description;
        this.univIds = univIds;
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


    public List<String> getUnivIds() {
        return univIds;
    }

    public void setUnivIds(List<String> univIds) {
        this.univIds = univIds;
    }
}
