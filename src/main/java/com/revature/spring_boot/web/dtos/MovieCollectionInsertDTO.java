package com.revature.spring_boot.web.dtos;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/13/2021
 * Time: 2:23 PM
 * Description: {Insert Description}
 */
public class MovieCollectionInsertDTO {

    private int collectionInfoId;

    private int movieID;

    private int owned;

    private int watched;

    private int userRating;

    private int tradable;

    private String userDescrip;

    public MovieCollectionInsertDTO() {
        super();
    }

    public int getCollectionInfoId() {
        return collectionInfoId;
    }

    public void setCollectionInfoId(int collectionInfoId) {
        this.collectionInfoId = collectionInfoId;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
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
}
