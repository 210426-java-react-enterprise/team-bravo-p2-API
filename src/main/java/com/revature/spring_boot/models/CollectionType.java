package com.revature.spring_boot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


/**
 *
 *  Model for using an existing account type from the database
 *
 */
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

    @JsonIgnore
    @OneToMany(mappedBy="collectionType"/*, fetch = FetchType.LAZY*/)
    private List<CollectionInfo> collectionInfoSet;

    public List<CollectionInfo> getCollectionInfoSet() {
        return collectionInfoSet;
    }

    public CollectionType(){super();}

    public CollectionType(CollectionTypeDTO collectionTypeDTO){
        this.id = collectionTypeDTO.getId();
        this.mediumType = collectionTypeDTO.getMediumType();
    }

    public void setCollectionInfoSet(List<CollectionInfo> collectionInfoSet) {
        this.collectionInfoSet = collectionInfoSet;
    }

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
