package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Director;
import com.revature.spring_boot.models.MovieDirector;
import com.revature.spring_boot.models.Movies;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieDirectorDTO {

    @NotEmpty
    private int id;

    @NotEmpty
    private List<MovieDTO> movieList;

//    @NotEmpty
//    private List<Director> directorList;

    public MovieDirectorDTO(){
        super();
        movieList = new ArrayList<>();
    }

    public MovieDirectorDTO(MovieDirector movieDirector){
        this.id = movieDirector.getMovieDirectorId();
        this.movieList = movieDirector.getMovies().stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieDTO> getMovie() {
        return movieList;
    }

    public void setMovie(List<MovieDTO> movie) {
        this.movieList = movie;
    }

//    public List<Director> getDirector() {
//        return directorList;
//    }
//
//    public void setDirector(List<Director> director) {
//        this.directorList = director;
//    }
}
