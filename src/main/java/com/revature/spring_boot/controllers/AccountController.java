package com.revature.spring_boot.controllers;


import com.revature.spring_boot.dtos.Credentials;
import com.revature.spring_boot.dtos.RegDTO;
import com.revature.spring_boot.jwt.JwtConfig;
import com.revature.spring_boot.jwt.TokenGenerator;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.User;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    private TokenGenerator tokenGenerator;
    private JwtConfig jwtConfig;

    @Autowired
    public AccountController(AccountRepository accountRepo, UserRepository userRepo, TokenGenerator tokenGenerator, JwtConfig jwtConfig) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
        this.tokenGenerator = tokenGenerator;
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/test")
    public String test() {
        logger.info("/users/test invoked at {}", LocalDateTime.now());
        return "/users/test works!";
    }

    @PostMapping(value = "/login", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Account authenticate(@RequestBody @Valid Credentials creds, HttpServletResponse resp) {
        Account account = accountRepo.findAccountByUsernameAndPassword(creds.getUsername(), creds.getPassword());
        String jwt = tokenGenerator.createJwt(account);
        resp.setHeader(jwtConfig.getHeader(), jwt);
        return account;
    }

    @PostMapping(value="/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Map<String, Object> register(@RequestBody @Valid RegDTO regDTO){
        Account account = accountRepo.save(new Account(regDTO.getEmail(), regDTO.getUsername(), regDTO.getPassword()));
        User user = userRepo.save(new User(account.getId(), regDTO.getFirstName(), regDTO.getLastName(), regDTO.getAge()));
        Map<String, Object> map = new HashMap<>();
        map.put("User", user);
        map.put("Account", account);
        return map;
    }


}
