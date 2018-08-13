package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "univFamily", indexes = {@Index(name = "universeId", unique = true, columnList = "universeId"),
        @Index(name = "familyId", unique = true, columnList = "familyId")})


public class UnivFamily {
    @Id
    @NotNull
    private String id;
    @NotNull
    private String universeId;
    @NotNull
    private String familyId;

    public UnivFamily(@NotNull String id, @NotNull String universeId, @NotNull String familyId) {
        this.id = id;
        this.universeId = universeId;
        this.familyId = familyId;
    }

    public UnivFamily() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUniverseId() {
        return universeId;
    }

    public void setUniverseId(String universeId) {
        this.universeId = universeId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

}
