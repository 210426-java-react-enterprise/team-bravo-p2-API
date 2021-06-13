package com.revature.spring_boot.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movie_collections")
public class MovieCollections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="collection_id")
    private int collItemId;

    @NotNull
    @Column(name ="owned", nullable = false)
    private int owned;

    @NotNull
    @Column(name ="watched", nullable = false)
    private int watched;

    @Column(name ="user_rating")
    private int userRating;

    @Column(name ="user_comment")
    private String userComment;

    @Column(name ="tradeable")
    private int tradeable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_info_id", nullable = false, referencedColumnName = "collection_info_id")
    private CollectionInfo collectionInfo;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false, referencedColumnName = "movie_id")
    private Movies movieId;

    public MovieCollections(MovieCollectionsDTO collection) {
        this.collItemId = collection.getId();
        this.movieId = new Movies(collection.getMovie());
        this.collectionInfo = new CollectionInfo(collection.getCollectionInfo());
        this.owned = collection.getOwned();
        this.userRating = collection.getUserRating();
        this.userComment = collection.getUserDescrip();
        this.tradeable = collection.getTradeable();
        this.watched = collection.getWatched();
    }

    public MovieCollections() {

    }


    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }


    public void setMovieId(Movies movieId) {
        this.movieId = movieId;
    }

    public int getCollItemId() {
        return collItemId;
    }

    public void setCollId(int collId) {
        this.collItemId = collId;
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

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public int getTradeable() {
        return tradeable;
    }

    public void setTradeable(int tradeable) {
        this.tradeable = tradeable;
    }

    public int getMovieId() {
        return collItemId;
    }

    public void setCollItemId(int collItemId) {
        this.collItemId = collItemId;
    }

    @Override
    public String toString() {
        return "MovieCollections{" +
                "collItemId=" + collItemId +
                ", owned=" + owned +
                ", watched=" + watched +
                ", userRating=" + userRating +
                ", userComment='" + userComment + '\'' +
                ", tradeable=" + tradeable +
                ", collectionInfo=" + collectionInfo +
                ", movieId=" + movieId +
                '}';
    }
}
