package com.revature.spring_boot.web.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.web.dtos.Credentials;
import com.revature.spring_boot.web.dtos.RegDTO;
import com.revature.spring_boot.web.security.TokenGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AccountControllerIntegrationTestSuite {

    private MockMvc mockMvc;

    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;

    @Autowired
    public AccountControllerIntegrationTestSuite(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }

    @AfterEach
    public void teardown(){
    }

    @Test
    public void test_register() throws Exception {

        RegDTO mockReg = new RegDTO();
        mockReg.setAge(30);
        mockReg.setEmail("mock6@mock.com");
        mockReg.setFirstName("mock6");
        mockReg.setLastName("mocker6");
        mockReg.setPassword("mockPass6");
        mockReg.setUsername("mockman6");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/accounts/register")
                .content(asJsonString(mockReg))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void login() throws Exception{
        accountRepo.save(new Account("mock6@mock.com", "mockman6", "mockPass6"));

        Credentials creds = new Credentials();
        creds.setUsername("mockman6");
        creds.setPassword("mockPass6");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/accounts/login")
                .content(asJsonString(creds))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

//    @Test
//    public void test_delete(){
//
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





}