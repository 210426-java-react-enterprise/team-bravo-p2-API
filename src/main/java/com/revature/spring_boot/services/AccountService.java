package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.*;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.User;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 7:52 PM
 * Description: {Insert Description}
 */

@Service
@Transactional
public class AccountService {

    private AccountRepository acctRepo;
    private UserRepository userRepo;

    @Autowired
    public AccountService(AccountRepository acctRepo, UserRepository userRepo) {
        this.acctRepo = acctRepo;
        this.userRepo = userRepo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean isUsernameAvailable(String username) {

        if (!isValid(username, "username"))
            throw new InvalidRequestException("Invalid username value provided!");

        try {
            return acctRepo.isUsernameAvailable(username);
        } catch (Exception e) {
            throw new DataSourceException(e);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean isEmailAvailable(String email) {

        if (!isValid(email, "email"))
            throw new InvalidRequestException("Invalid email value provided!");

        try {
            return acctRepo.isEmailAvailable(email);
        } catch (Exception e) {
            if (e instanceof ResourceNotFoundException) throw e;
            throw new DataSourceException(e);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Account registerAccount(Account newAcct) throws InvalidRequestException, ResourcePersistenceException {

        isAccountValid(newAcct);

        if (isUsernameAvailable(newAcct.getUsername())) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        if (isEmailAvailable(newAcct.getEmail())) {
            throw new ResourcePersistenceException("Provided email is already taken!");
        }

        return acctRepo.save(newAcct);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User registerUser(User newUser) throws InvalidRequestException, ResourcePersistenceException {

        isUserValid(newUser);

        return userRepo.save(newUser);
    }

    @Transactional(readOnly = true)
    public Account authenticate(String username, String password) throws AuthException {

        if (!isValid(username, "username") && !isValid(password, "password"))
            throw new InvalidRequestException("Invalid username value provided!");

        try {
            return acctRepo.findAccountByUsernameAndPassword(username, password)
                    .orElseThrow(AuthException::new);
        } catch (Exception e) {
            if (e instanceof ResourceNotFoundException) throw e;
            throw new DataSourceException(e);
        }

    }

    public void isAccountValid(Account a) throws InvalidRequestException {

        if (a == null)
            throw new InvalidRequestException("A null user was provided.");

        if (!isValid(a.getUsername(), "username"))
            throw new InvalidRequestException("An invalid username was provided.");

        if (!isValid(a.getPassword(), "password"))
            throw new InvalidRequestException("An invalid password was provided.");

        if (!isValid(a.getEmail(), "email"))
            throw new InvalidRequestException("An invalid email was provided.");

    }

    public void isUserValid(User u) throws InvalidRequestException {

        if (u == null)
            throw new InvalidRequestException("A null user was provided.");

        if (!isValid(u.getFirstName(), "firstName"))
            throw new InvalidRequestException("An invalid first name was provided.");

        if (!isValid(u.getLastName(), "lastName"))
            throw new InvalidRequestException("An invalid last name was provided.");

    }

    public boolean isValid(String str, String fieldName) {

        if (str == null || str.trim().isEmpty()) return false;

        switch (fieldName) {
            case "username":
                return str.length() <= 20;
            case "firstName":
            case "lastName":
                return str.length() <= 25;
            case "password":
            case "email":
                return str.length() <= 255;
            default:
                return false;
        }


    }

}
