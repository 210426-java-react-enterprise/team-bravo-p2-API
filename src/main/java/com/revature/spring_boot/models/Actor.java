package com.revature.spring_boot.models;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ann-Aisha Louis-Charles
 * Date: 6/8/2021
 * Time: 10:02 PM
 *
 */

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private int actorId;

    //instantiate movie actors
    //manytomany

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
