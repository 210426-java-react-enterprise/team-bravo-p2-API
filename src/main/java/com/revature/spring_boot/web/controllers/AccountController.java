package com.revature.spring_boot.web.controllers;


import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.web.dtos.Credentials;
import com.revature.spring_boot.web.dtos.RegDTO;
import com.revature.spring_boot.services.AccountService;
import com.revature.spring_boot.web.dtos.AccountDTO;
import com.revature.spring_boot.web.security.JwtConfig;
import com.revature.spring_boot.web.security.TokenGenerator;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.User;
import com.revature.spring_boot.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller class exposing account based endpoints
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);
    private AccountService accountService;
    private TokenGenerator tokenGenerator;
    private JwtConfig jwtConfig;

    @Autowired
    public AccountController(AccountService accountService, TokenGenerator tokenGenerator, JwtConfig jwtConfig) {
        this.accountService = accountService;
        this.tokenGenerator = tokenGenerator;
        this.jwtConfig = jwtConfig;
    }

    /**
     * Route a user would use to login
     * @param creds
     * @param resp
     * @return
     */
    @PostMapping(value = "/login", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public AccountDTO authenticate(@RequestBody @Valid Credentials creds, HttpServletResponse resp) {
        Account account = accountService.authenticate(creds.getUsername(), creds.getPassword());
        String jwt = tokenGenerator.createJwt(account);
        resp.setHeader(jwtConfig.getHeader(), jwt);

        return new AccountDTO(account);
    }

    /**
     * Route a user would use to register a new account
     * @param regDTO
     */
    @PostMapping(value="/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public void register(@RequestBody @Valid RegDTO regDTO){
        Account account = accountService.registerAccount(new Account(regDTO.getEmail(), regDTO.getUsername(), regDTO.getPassword()));
        accountService.registerUser(new User(account.getId(), regDTO.getFirstName(), regDTO.getLastName(), regDTO.getAge()));
    }

}
