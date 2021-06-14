package com.revature.spring_boot.web.controllers;


import com.revature.spring_boot.models.Actor;
import com.revature.spring_boot.repos.ActorRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ActorsControllerIntegrationTestSuite {
    private MockMvc mockMvc;
    private WebApplicationContext webContext;

    @Autowired
    public ActorsControllerIntegrationTestSuite(WebApplicationContext webContext){
        this.webContext = webContext;
    }

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }

    @Test
    public void test_getAllActors() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/actors/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
