package com.revature.spring_boot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie_directors")
public class MovieDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "md_key", nullable = false)
    private int movieDirectorId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie", nullable = false)
    private List<Movies> movies;

    @JoinTable(
            name = "movieDirector",
            joinColumns = @JoinColumn(name = "director"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )

    @ManyToMany(mappedBy = "movieDirectorList")
    private List<Director> directorList;


    public int getMovieDirectorId() {
        return movieDirectorId;
    }

    public void setMovieDirectorId(int movieDirectorId) {
        this.movieDirectorId = movieDirectorId;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }
}
