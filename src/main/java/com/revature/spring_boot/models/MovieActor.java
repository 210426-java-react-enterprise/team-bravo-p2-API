package com.revature.spring_boot.models;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/7/2021
 * Time: 6:48 PM
 * Description: {Insert Description}
 */

@Entity
@Table(name = "movie_actors" )
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_key", nullable = false)
    private int movieActorId;

//Instantiate actors? manytomany
    //private Actors actors;

    //instantiate movies many to one
//    @Column(name = "movie_id", nullable = false)
//    private Movie movieId;

}
