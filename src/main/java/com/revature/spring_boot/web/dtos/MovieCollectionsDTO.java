package com.revature.spring_boot.web.dtos;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.spring_boot.models.MovieCollections;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:38 PM
 * Description: {Insert Description}
 */
public class MovieCollectionsDTO {

    private int id;

    @JsonProperty("collInfo")
    private CollectionInfoDTO collectionInfo;

    @JsonProperty("movie")
    private MovieDTO movie;

    @JsonProperty("owned")
    private int owned;

    @JsonProperty("watched")
    private int watched;

    @JsonProperty("user_rating")
    private int userRating;

    @JsonProperty("tradeable")
    private int tradeable;

    @JsonProperty("user_comment")
    private String userDescrip;

    public MovieCollectionsDTO() {
        super();
        //this.collectionInfo = new CollectionInfoDTO();
        this.movie = new MovieDTO();
    }

    public MovieCollectionsDTO(MovieCollections movieCollect) {
        this.id = movieCollect.getCollItemId();
        this.collectionInfo = new CollectionInfoDTO(movieCollect.getCollectionInfo());
        this.movie = new MovieDTO(movieCollect.getMovieId());
        this.owned = movieCollect.getOwned();
        this.watched = movieCollect.getWatched();
        this.tradeable = movieCollect.getTradeable();
        this.userDescrip = movieCollect.getUserComment();

    }


    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public CollectionInfoDTO getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(CollectionInfoDTO collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getTradeable() {
        return tradeable;
    }

    public void setTradeable(int tradable) {
        this.tradeable = tradable;
    }

    public String getUserDescrip() {
        return userDescrip;
    }

    public void setUserDescrip(String userDescrip) {
        this.userDescrip = userDescrip;
    }

    //public CollectionInfoDTO getCollectionInfo() {
    //    return collectionInfo;
    //}

    // void setCollectionInfo(CollectionInfoDTO collectionInfo) {
    //    this.collectionInfo = collectionInfo;
    //}



}
