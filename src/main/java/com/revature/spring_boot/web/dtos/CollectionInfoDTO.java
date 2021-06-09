package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.CollectionInfo;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:24 PM
 * Description: {Insert Description}
 */
public class CollectionInfoDTO {

    private int id;

    @NotEmpty
    private AccountDTO account;

    @NotEmpty
    private CollectionTypeDTO collType;

    @NotEmpty
    private String collectionName;

    @NotEmpty
    private String collectionDescrip;

    public CollectionInfoDTO() {
        super();
        this.account = new AccountDTO();
        this.collType = new CollectionTypeDTO();
    }

    public CollectionInfoDTO(CollectionInfo collInfo) {
        this.id = collInfo.getCollectionInfoId();
        this.account = new AccountDTO(collInfo.getAcctId());
        this.collType = new CollectionTypeDTO(collInfo.getCollectionType());
        this.collectionName = collInfo.getCollectionName();
        this.collectionDescrip = collInfo.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionDescrip() {
        return collectionDescrip;
    }

    public void setCollectionDescrip(String collectionDescrip) {
        this.collectionDescrip = collectionDescrip;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public CollectionTypeDTO getCollType() {
        return collType;
    }

    public void setCollType(CollectionTypeDTO collType) {
        this.collType = collType;
    }
}
