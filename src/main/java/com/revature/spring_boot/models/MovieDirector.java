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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie", nullable = false)
    private Movies movies;

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
}
