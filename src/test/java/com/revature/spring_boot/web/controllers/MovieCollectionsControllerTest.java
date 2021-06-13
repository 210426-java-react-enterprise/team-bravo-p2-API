package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.*;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.services.MovieCollectionService;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MovieCollectionsControllerTest {

    private MockMvc mockMvc;

    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;

    private MovieCollectionService mockMCS;
    private List<MovieCollections> movieCollectionsList;
    private List<MovieCollectionsDTO> movieCollectionsDTOList;
    private Account account;
    //private MovieCollectionsRepository mockMovieCollectionRepo;
    private CollectionInfo collectionInfo;
    private CollectionType collectionType;
    private MovieCollections movieCollections;
    private MovieCollectionsDTO movieCollectionsDTO;
    private Movies movie1;

    @Autowired
    public MovieCollectionsControllerTest(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        mockMCS = mock(MovieCollectionService.class);

        //mockMovieCollectionRepo = mock(MovieCollectionsRepository.class);

        account = new Account("test@test.com", "Tester", "testing123");
        account.setId(1);

        collectionType = new CollectionType();
        collectionType.setId(1);
        collectionType.setMediumType("Movies");

        collectionInfo = new CollectionInfo();
        collectionInfo.setCollectionInfoId(1);
        collectionInfo.setCollectionName("CollectionTest");
        collectionInfo.setCollectionType(collectionType);
        collectionInfo.setDescription("Collection test.");

        movie1 = new Movies();
        movie1.setMovieId(1);
        movie1.setTitle("Whiplash");
        movie1.setLengthMin(106);
        movie1.setMpaaRating("R");
        movie1.setYear(2014);
        movie1.setProdCompany("Blumhouse");
        movie1.setGenre("Drama, Music");
        movie1.setDescription("About a drummer and his teacher.");

        movieCollections = new MovieCollections();
        movieCollections.setTradeable(0);
        movieCollections.setMovies(movie1);
        movieCollections.setCollId(1);
        movieCollections.setUserComment("This is just a test.");
        movieCollections.setWatched(0);
        movieCollections.setTradeable(0);
        movieCollections.setOwned(0);
        movieCollections.setUserRating(10);
        movieCollections.setCollectionInfo(collectionInfo);

        movieCollectionsDTO = new MovieCollectionsDTO(movieCollections);

        movieCollectionsDTOList = new ArrayList<>();
        movieCollectionsDTOList.add(movieCollectionsDTO);
    }


    @AfterEach
    public void teardown(){
        mockMCS = null;
        mockMvc = null;
        account = null;
        collectionType = null;
        collectionInfo = null;
        movie1 = null;
        movieCollections = null;
        movieCollectionsDTO = null;
        movieCollectionsDTOList = null;
    }


    @Test
    public void test_getAllMovieCollections() throws Exception {

        when(mockMCS.getAllMovieCollections()).thenReturn(movieCollectionsList);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/movieCollections/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    //Added "id" to getMovieCollectionsById method in original class
    @Test
    public void test_getMovieCollectionsById() throws Exception {

        when(mockMCS.getMovieCollectionsById(any(Integer.class))).thenReturn(movieCollections);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/movieCollections/getByID/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
