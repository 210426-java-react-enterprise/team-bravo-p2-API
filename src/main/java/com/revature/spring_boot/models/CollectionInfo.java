package com.revature.spring_boot.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "collection_info")
public class CollectionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="collection_info_id")
    private int collectionInfoId;

    //FK
    @ManyToOne
    @JoinColumn(name = "acct_id", nullable = false)
    private Account acctId;

    @NotNull
    @Column(name = "coll_name", nullable = false)
    private String collectionName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "collectionInfo")
    @JsonIgnore
    private List<MovieCollections> movieCollectionsSet;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, referencedColumnName = "coll_type_id")
    private CollectionType collectionType;

    public List<MovieCollections> getMovieCollectionsSet() {
        return movieCollectionsSet;
    }

    public void setMovieCollectionsSet(List<MovieCollections> movieCollectionsSet) {
        this.movieCollectionsSet = movieCollectionsSet;
    }

    public CollectionInfo(){};

    public CollectionInfo(CollectionInfoDTO collectionInfoDTO){
        this.collectionName = collectionInfoDTO.getCollectionName();
        this.acctId = new Account(collectionInfoDTO.getAccount());
        this.collectionName = collectionInfoDTO.getCollectionName();
        this.description = collectionInfoDTO.getCollectionDescrip();
        this.collectionType = new CollectionType(collectionInfoDTO.getCollType());
    };


    public CollectionType getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(CollectionType collectionType) {
        this.collectionType = collectionType;
    }

    public int getCollectionInfoId() {
        return collectionInfoId;
    }

    public void setCollectionInfoId(int collectionInfoId) {
        this.collectionInfoId = collectionInfoId;
    }

    public Account getAcctId() {
        return acctId;
    }

    public void setAcctId(Account acctId) {
        this.acctId = acctId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "collectionInfoId=" + collectionInfoId +
                ", acctId=" + acctId +
                ", collectionName='" + collectionName + '\'' +
                ", description='" + description + '\'' +
                ", movieCollectionsSet=" + movieCollectionsSet +
                ", collectionType=" + collectionType +
                '}';
    }
}
