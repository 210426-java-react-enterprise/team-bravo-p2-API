package com.revature.spring_boot.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="collection_types")
public class CollectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coll_type_id", nullable = false)
    private int id;

    @NotNull
    @Column(name = "medium_type",unique = true, nullable = false)
    private String mediumType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType;
    }
}
