package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.web.dtos.AccountDTO;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
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

    @Autowired
    public CollectionInfoControllerIntegrationTestSuite(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }

//    @Test
//    public void test_getCollectionInfoByID() throws Exception{
//        Account mockAccount = new Account("mockman@mock.com", "mockman", "mocker");
//        accountRepo.save(mockAccount);
//        AccountDTO mockAccountDTO = new AccountDTO(mockAccount);
//
//        CollectionInfo mockCollectionInfo = new CollectionInfo();
//
//
////        int accountID = tokenParser.tokenID(req);
////        System.out.println(accountID);
//        Account account = new Account();
//        account.setId(accountID);
//
//        List<CollectionInfoDTO> collectionInfo = collectionInfoRepository.findCollectionInfoByAccount_id(account)
//                .stream()
//                .map(CollectionInfoDTO::new)
//                .collect(Collectors.toList());
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/collection", 1).header("Authorization", token))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$[0].id").value(1));
//    }
//
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
