package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 5:54 PM
 * Description: {Insert Description}
 */
public class AccountDTO {

    private int id;

    @NotEmpty
    private String username;

    @Email
    private String email;

    public AccountDTO(){
        super();
    }

    public AccountDTO(Account acct){
        this.id = acct.getId();
        this.username = acct.getUsername();
        this.email = acct.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
