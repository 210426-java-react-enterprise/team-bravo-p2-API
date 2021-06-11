package com.revature.spring_boot.web.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.spring_boot.models.CollectionInfo;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:24 PM
 * Description: {Insert Description}
 */
public class CollectionInfoDTO {

    private int id;

    @JsonProperty("account")
//    @NotEmpty
    private AccountDTO account;

    @JsonProperty("collType")
//    @NotEmpty
    private CollectionTypeDTO collType;

    @JsonProperty("collectionName")
    @NotEmpty
    private String collectionName;

    @JsonProperty("collectionDescrip")
    @NotEmpty
    private String collectionDescrip;

    private List<MovieCollectionsDTO> movieCollections;

    public CollectionInfoDTO() {
        super();
        this.account = new AccountDTO();
        this.collType = new CollectionTypeDTO();
        this.movieCollections = new ArrayList<>();
    }

    public CollectionInfoDTO(CollectionInfo collInfo) {
        this.id = collInfo.getCollectionInfoId();
        this.account = new AccountDTO(collInfo.getAcctId());
        this.collType = new CollectionTypeDTO(collInfo.getCollectionType());
        this.collectionName = collInfo.getCollectionName();
        this.collectionDescrip = collInfo.getDescription();
        this.movieCollections = collInfo.getMovieCollectionsSet().stream().map(MovieCollectionsDTO::new).collect(Collectors.toList());
    }

    public CollectionInfoDTO(CollectionInfo collInfo, int jamesSwitch) {
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

    public List<MovieCollectionsDTO> getMovieCollections() {
        return movieCollections;
    }

    public void setMovieCollections(List<MovieCollectionsDTO> movieCollections) {
        this.movieCollections = movieCollections;
    }
}
