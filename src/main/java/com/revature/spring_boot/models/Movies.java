package com.revature.spring_boot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private int movieId;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "year", nullable = false)
    private int year;

    @NotNull
    @Column(name = "mpaa_rating", nullable = false)
    private String mpaaRating;

    @NotNull
    @Column(name = "length_min", nullable = false)
    private int lengthMin;

    @NotNull
    @Column(name = "genre", nullable = false)
    private String genre;

    @NotNull
    @Column(name = "descrip", nullable = false)
    private String description;

    @NotNull
    @Column(name = "prod_company", nullable = false)
    @JsonProperty("Production")
    private String prodCompany;

    @JsonIgnore
    @OneToMany(mappedBy = "movies")
    private List<MovieCollections> movieCollectionSet;

    @ManyToMany(targetEntity = Director.class)
    @JoinTable(
            name = "movie_directors",
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "director")
    )
    private List<Director> directorList;

    @ManyToMany(targetEntity = Actor.class)
    @JoinTable(
            name = "movie_actors",
            joinColumns ={ @JoinColumn(name = "movie")},
            inverseJoinColumns = @JoinColumn(name = "actor")
    )
    private List<Actor> actorList;

    public List<MovieCollections> getMovieCollectionSet() {
        return movieCollectionSet;
    }

    public void setMovieCollectionSet(List<MovieCollections> movieCollectionSet) {
        this.movieCollectionSet = movieCollectionSet;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public int getLengthMin() {
        return lengthMin;
    }

    public void setLengthMin(int lengthMin) {
        this.lengthMin = lengthMin;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProdCompany() {
        return prodCompany;
    }

    public void setProdCompany(String prodCompany) {
        this.prodCompany = prodCompany;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
