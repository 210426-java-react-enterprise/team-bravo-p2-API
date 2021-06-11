package com.revature.spring_boot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.*;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by IntelliJ IDEA.
// * User: Jbialon
// * Date: 6/7/2021
// * Time: 6:48 PM
// * Description: {Insert Description}
// */
//
//@Entity
//@Table(name = "movie_actors" )
//public class MovieActor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ma_key", nullable = false)
//    private int movieActorId;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "movie", nullable = false)
//    private Movies movies;
//
//
//    @JoinTable(
//            name = "movieActor",
//            joinColumns = @JoinColumn(name = "actor"),
//            inverseJoinColumns = @JoinColumn(name = "actor_id")
//    )
//    @ManyToMany(mappedBy = "movieActorList")
//    private List<Actor> actorList;
//
//    public int getMovieActorId() {
//        return movieActorId;
//    }
//
//    public void setMovieActorId(int movieActorId) {
//        this.movieActorId = movieActorId;
//    }
//
//}
