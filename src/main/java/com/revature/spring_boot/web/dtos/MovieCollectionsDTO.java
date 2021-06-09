package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.MovieCollections;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:38 PM
 * Description: {Insert Description}
 */
public class MovieCollectionsDTO {

    private int id;

    //@NotEmpty
    //private CollectionInfoDTO collectionInfo;

    @NotEmpty
    private MovieDTO movie;

    @NotEmpty
    private int owned;

    @NotEmpty
    private int watched;

    private int userRating;

    private int tradable;

    private String userDescrip;

    public MovieCollectionsDTO() {
        super();
        //this.collectionInfo = new CollectionInfoDTO();
        this.movie = new MovieDTO();
    }

    public MovieCollectionsDTO(MovieCollections movieCollect) {
        this.id = movieCollect.getCollItemId();
        //this.collectionInfo = new CollectionInfoDTO(movieCollect.getCollectionInfo());
        this.movie = new MovieDTO(movieCollect.getMovies());
        this.owned = movieCollect.getOwned();
        this.watched = movieCollect.getWatched();
        this.tradable = movieCollect.getTradeable();
        this.userDescrip = movieCollect.getUserComment();
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

    public int getTradable() {
        return tradable;
    }

    public void setTradable(int tradable) {
        this.tradable = tradable;
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

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieCollectionsDTO{" +
                "id=" + id +
                ", owned=" + owned +
                ", watched=" + watched +
                ", userRating=" + userRating +
                ", tradable=" + tradable +
                ", userDescrip='" + userDescrip + '\'' +
                '}';
    }
}
