//package com.revature.spring_boot.models;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by IntelliJ IDEA.
// * User: Ann-Aisha Louis-Charles
// * Date: 6/8/2021
// * Time: 10:02 PM
// *
// */
//
//@Entity
//@Table(name = "actors")
//public class Actor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "actor_id", nullable = false)
//    private int actorId;
//
//    @ManyToMany
//    @JoinTable(
//            name = "Actor",
//            joinColumns ={ @JoinColumn(name = "actor_id")},
//            inverseJoinColumns = @JoinColumn(name = "actor")
//    )
//    private List<MovieActor> movieActorList;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    public int getActorId() {
//        return actorId;
//    }
//
//    public void setActorId(int actorId) {
//        this.actorId = actorId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//}
