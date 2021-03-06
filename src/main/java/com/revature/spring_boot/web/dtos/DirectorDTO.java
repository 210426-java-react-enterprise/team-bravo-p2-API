package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Director;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Tdiendorf
 * Date: 6/9/2021
 * Time: 7:15 PM
 * Description: {Insert Description}
 */
public class DirectorDTO {

    private int id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private List<MovieDTO> movieDTOList;

    public DirectorDTO(){
        super();
        movieDTOList = new ArrayList<>();
    }

    public DirectorDTO(Director director){
        this.id = director.getId();
        this.firstName = director.getFirstName();
        this.lastName = director.getLastName();
        this.movieDTOList = director.getMovieDirectorList().stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
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

    public List<MovieDTO> getMovieDTOList() {
        return movieDTOList;
    }

    public void setMovieDTOList(List<MovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                '}';
    }

}
