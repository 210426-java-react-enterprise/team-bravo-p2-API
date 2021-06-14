package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.Director;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.services.DirectorService;
import com.revature.spring_boot.web.security.TokenGenerator;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DirectorControllerTest {

    private MockMvc mockMvc;

    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;

    private DirectorService mockDirectorService;

    @Autowired
    public DirectorControllerTest(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        mockDirectorService = mock(DirectorService.class);
    }

    @Test
    public void test_getAllDirectors() throws Exception {
        Director director = new Director();
        director.setId(1);
        director.setFirstName("Testy");
        director.setLastName("Tester");

        List<Director> directorList = new ArrayList<>();
        directorList.add(director);

        when(mockDirectorService.getDirectorList()).thenReturn(directorList);

        mockMvc.perform(MockMvcRequestBuilders.get("/director/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
