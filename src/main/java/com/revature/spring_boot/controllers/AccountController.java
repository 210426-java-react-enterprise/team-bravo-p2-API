package com.revature.spring_boot.controllers;


import com.revature.spring_boot.dtos.Credentials;
import com.revature.spring_boot.dtos.RegDTO;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.User;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);
    private AccountRepository accountRepo;
    private UserRepository userRepo;

    @Autowired
    public AccountController(AccountRepository accountRepo, UserRepository userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/test")
    public String test() {
        logger.info("/users/test invoked at {}", LocalDateTime.now());
        return "/users/test works!";
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Account registerNewAccount(@RequestBody @Valid Account newAccount) {
        return accountRepo.save(newAccount);
    }

    @PostMapping(value = "/login", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Account authenticate(@RequestBody @Valid Credentials creds) {
        return accountRepo.findAccountByUsernameAndPassword(creds.getUsername(), creds.getPassword());
    }

 /*   @PostMapping(value="/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Map<String, Object> register(@RequestBody @Valid RegDTO regDTO){
        Account account = new Account(regDTO.getEmail(), regDTO.getUsername(), regDTO.getPassword());
        accountRepo.save(account);
        User user = new User(account.getId(), regDTO.getFirstName(), regDTO.getLastName(), regDTO.getAge());
        userRepo.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("User", user);
        map.put("Account", account);
        return map;
    } */


}
