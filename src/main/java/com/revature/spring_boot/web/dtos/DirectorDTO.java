package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Director;

import javax.validation.constraints.NotEmpty;

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

    public DirectorDTO(){super();}

    public DirectorDTO(Director director){
        this.id = director.getId();
        this.firstName = director.getFirstName();
        this.lastName = director.getLastName();
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                '}';
    }

}
