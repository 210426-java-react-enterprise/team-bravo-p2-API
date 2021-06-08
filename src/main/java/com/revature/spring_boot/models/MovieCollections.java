package com.revature.spring_boot.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movie_collections")
public class MovieCollections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="collection_id")
    private int collId;

    @NotNull
    @Column(name = "collection_info_id", nullable = false)
    private int collInfoId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "collection_info_id", referencedColumnName = "collection_info_id")
//    private CollectionInfo collInfoIdClass;

    @NotNull
    @Column(name="movie_id", nullable = false)
    private int movieId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
//    private Movies moviesIdClass;

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

    @ManyToOne()
    @JoinColumn(name = "collection_info_id", nullable = false, insertable = false, updatable = false)
    private CollectionInfo collectionInfo;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false, insertable = false, updatable = false)
    private Movies movies;


    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public int getCollId() {
        return collId;
    }

    public void setCollId(int collId) {
        this.collId = collId;
    }

    public int getCollInfoId() {
        return collInfoId;
    }

    public void setCollInfoId(int collInfoId) {
        this.collInfoId = collInfoId;
    }

//    public CollectionInfo getCollInfoIdClass() {
//        return collInfoIdClass;
//    }

//    public void setCollInfoIdClass(CollectionInfo collInfoIdClass) {
//        this.collInfoIdClass = collInfoIdClass;
//    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

//    public Movies getMoviesIdClass() {
//        return moviesIdClass;
//    }

//    public void setMoviesIdClass(Movies moviesIdClass) {
//        this.moviesIdClass = moviesIdClass;
//    }

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

}
