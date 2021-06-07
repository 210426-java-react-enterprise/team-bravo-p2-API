package com.revature.spring_boot.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/7/2021
 * Time: 11:11 AM
 * Description: {Insert Description}
 */


@Entity
@Table(name = "movie_collections", schema = "project_two")
public class MovieCollections {

    @Id()
    @Column(name = "collection_id")
    private int collectionId;

    @NotNull
    @Column(name = "collection_info_id")
    private int collectionInfoId;

    @NotNull
    @Column(name = "movie_id")
    private int movieId;

    @NotNull
    @Column()
    private int owned;

    @NotNull
    @Column()
    private int watched;

    @Column(name = "user_rating")
    private int userRating;

    @Column()
    private int tradeable;

    @Column(name = "user_comment")
    private String userComment;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getCollectionInfoId() {
        return collectionInfoId;
    }

    public void setCollectionInfoId(int collectionInfoId) {
        this.collectionInfoId = collectionInfoId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public void setTradeable(int tradeable) {
        this.tradeable = tradeable;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
