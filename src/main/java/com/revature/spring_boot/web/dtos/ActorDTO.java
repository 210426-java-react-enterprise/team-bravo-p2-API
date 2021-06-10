package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Actor;
import com.revature.spring_boot.models.Movies;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 8:37 AM
 * Description: {Insert Description}
 */
public class ActorDTO {

    private int id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private List<MovieDTO> moviesList;

    public ActorDTO(){
        super();
        moviesList = new ArrayList<>();
    }

    public ActorDTO(Actor actor) {
        this.id = actor.getActorId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.moviesList = actor.getMoviesList().stream().map(MovieDTO::new).collect(Collectors.toList());;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<MovieDTO> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<MovieDTO> moviesList) {
        this.moviesList = moviesList;
    }
}
