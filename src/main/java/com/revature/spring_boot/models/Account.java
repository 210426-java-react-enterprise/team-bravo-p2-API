package com.revature.spring_boot.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.spring_boot.web.dtos.AccountDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "acct_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "acctId")
    private List<CollectionInfo> userCollections;

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Account(){

    }

    public Account(AccountDTO accountDTO){
        this.id = accountDTO.getId();
        this.email = accountDTO.getEmail();
        this.username = accountDTO.getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CollectionInfo> getUserCollections() {
        return userCollections;
    }

    public void setUserCollections(List<CollectionInfo> userCollections) {
        this.userCollections = userCollections;
    }
}
