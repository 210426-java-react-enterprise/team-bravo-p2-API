package com.revature.spring_boot.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;



public class MovieDirector {
  /*
 * Description: {To be a part of a list of directors (which will have it's own table,
 * with a foreign key referencing this table).}
 */
@Entity
@Table(name = "directors")
public class MovieDirector {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//primary key

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

}
