package com.revature.spring_boot.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.CollectionTypeRepository;
import com.revature.spring_boot.web.dtos.AccountDTO;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;
import com.revature.spring_boot.web.security.TokenGenerator;
import com.revature.spring_boot.web.security.TokenParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CollectionInfoControllerIntegrationTestSuite {

    private MockMvc mockMvc;
    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;
    private CollectionTypeRepository collectionTypeRepo;

    @Autowired
    public CollectionInfoControllerIntegrationTestSuite(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo, CollectionTypeRepository collectionTypeRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
        this.collectionTypeRepo  = collectionTypeRepo;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();


    }


    @Test
    public void test_saveCollectionInfo() throws Exception {
        AccountDTO mockAccountDTO = new AccountDTO();
        mockAccountDTO.setEmail("mocker9@mock.com");
        mockAccountDTO.setUsername("mockman9");

        Account mockAccount = new Account(mockAccountDTO);
        mockAccount.setPassword("mocker");
        accountRepo.save(mockAccount);
        mockAccountDTO.setId(mockAccount.getId());

        CollectionTypeDTO mockCollectionTypeDTO = new CollectionTypeDTO();
        mockCollectionTypeDTO.setMediumType("BoardGames");

        CollectionType mockCollectionType = new CollectionType(mockCollectionTypeDTO);
        collectionTypeRepo.save(mockCollectionType);
        mockCollectionTypeDTO.setId(mockCollectionType.getId());

        CollectionInfoDTO collectionInfoDTO = new CollectionInfoDTO();
        collectionInfoDTO.setCollectionDescrip("mockDescription");
        collectionInfoDTO.setCollectionName("mockName");
        collectionInfoDTO.setCollType(mockCollectionTypeDTO);
        collectionInfoDTO.setId(50);
        collectionInfoDTO.setAccount(mockAccountDTO);



        this.mockMvc.perform(MockMvcRequestBuilders.post("/collection/save")
                .content(asJsonString(collectionInfoDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


    }



    @Test
    public void test_getCollectionInfoByID() throws Exception{
        Account mockAccount = new Account("mockman7@mock.com", "mockman7", "mocker7");
        accountRepo.save(mockAccount);
        String token = tokenGenerator.createJwt(mockAccount);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/collection/get-info-by-id").header("Authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    public void test_getUserById_givenValidId() throws Exception {
//
//        Account mockAccount = new Account();
//        String token = tokenGenerator.createJwt(mockAccount);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/collection/getInfoByID").header("Authorization", token))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$[0].id").value(1));
//
//    }
//
//



}
