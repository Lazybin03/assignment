package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "univ_family", indexes = {@Index(name = "universeId", unique = false, columnList = "universeId"),
        @Index(name = "familyId", unique = false, columnList = "familyId")})


public class UnivFamily {
    @Id
    @Column(name = "id", unique = true)
    private String id;
    @NotNull
    @Column(name = "universeId", unique = false)
    private String universeId;
    @NotNull
    @Column(name = "familyId", unique = false)
    private String familyId;

    public UnivFamily(String id, @NotNull String universeId, @NotNull String familyId) {
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
