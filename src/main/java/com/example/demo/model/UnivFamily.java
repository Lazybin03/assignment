package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "univFamily", indexes = {@Index(name = "universeId", unique = true, columnList = "universeId"),
        @Index(name = "familyId", unique = true, columnList = "familyId")})


public class UnivFamily {
    @Id
    @NotNull
    private long id;
    @NotNull
    private long universeId;
    @NotNull
    private long familyId;

    public UnivFamily(@NotNull Long id, @NotNull Long universeId, @NotNull Long familyId) {
        this.id = id;
        this.universeId = universeId;
        this.familyId = familyId;
    }

    public UnivFamily() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getUniverseId() {
        return universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

}
