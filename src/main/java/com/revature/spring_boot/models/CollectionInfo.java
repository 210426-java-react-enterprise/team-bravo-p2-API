package com.revature.spring_boot.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "collection_info")
public class CollectionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="collection_info_id")
    private int collectionInfoId;

    //FK
    @NotNull
    @Column(name="acct_id",nullable = false)
     private int acctId;

    /**
     * Uncomment after accounts table is created
     * FK constraint
     */
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "acct_id", referencedColumnName = "acct_id")
    //private Accounts accountsAcctId

    //FK
    @NotNull
    @Column(name = "type_id",nullable = false)
    private int typeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "coll_type_type")
    private CollectionInfo collTypeId;

    @NotNull
    @Column(name = "coll_name", nullable = false)
    private String collectionName;

    @Column(name = "description")
    private String description;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setCollTypeId(CollectionInfo collTypeId) {
        this.collTypeId = collTypeId;
    }

    public CollectionInfo getCollTypeId() {
        return collTypeId;
    }

    public int getCollectionInfoId() {
        return collectionInfoId;
    }

    public void setCollectionInfoId(int collectionInfoId) {
        this.collectionInfoId = collectionInfoId;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public int getTypeID() {
        return typeId;
    }

    public void setTypeID(int typeID) {
        this.typeId = typeID;
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
}
