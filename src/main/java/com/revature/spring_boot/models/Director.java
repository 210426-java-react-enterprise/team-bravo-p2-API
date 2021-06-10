package com.revature.spring_boot.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * Description: {To be a part of a list of directors (which will have it's own table,
 * with a foreign key referencing this table; many-to-many relationship).}
 */
@Entity
@Table(name = "directors")
public class Director {

    @Id
    @Column(name = "director_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//primary key

    @ManyToMany
    @JoinTable(
            name = "Director",
            joinColumns = {@JoinColumn(name = "director_id")},
            inverseJoinColumns = @JoinColumn(name = "director")
    )

    private List<MovieDirector> movieDirectorList;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

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

    public List<MovieDirector> getMovieDirectorList() {
        return movieDirectorList;
    }

    public void setMovieDirectorList(List<MovieDirector> movieDirectorList) {
        this.movieDirectorList = movieDirectorList;
    }
}
