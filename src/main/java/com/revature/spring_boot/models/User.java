package com.revature.spring_boot.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private int age;

}
