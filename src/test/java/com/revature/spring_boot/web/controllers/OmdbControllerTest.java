package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.services.OmdbService;
import com.revature.spring_boot.web.dtos.MovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieSearchItemDTO;
import com.revature.spring_boot.web.security.TokenGenerator;
import org.junit.jupiter.api.AfterAll;
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

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OmdbControllerTest {

    private MockMvc mockMvc;

    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;

    private OmdbService mockOmdbService;
    private OmdbMovieSearchItemDTO movieSearchItemDTO;

    MovieDTO movieDTO;

    @Autowired
    public OmdbControllerTest(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        mockOmdbService = mock(OmdbService.class);

        movieDTO = new MovieDTO();
        movieDTO.setId(1);
        movieDTO.setTitle("Whiplash");
        movieDTO.setLengthMin(106);
        movieDTO.setMpaaRating("R");
        movieDTO.setYear(2014);
        movieDTO.setProdCompany("Blumhouse");
        movieDTO.setGenre("Drama, Music");
        movieDTO.setDescription("About a drummer and his teacher.");
        movieDTO.setImgUrl("https://m.media-amazon.com/images/M/MV5BOTA5NDZlZGUtMjAxOS00YTRkLTkwYmMtYWQ0NWEwZDZiNjEzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");

        movieSearchItemDTO = new OmdbMovieSearchItemDTO();
        movieSearchItemDTO.setImdbID("1");
        movieSearchItemDTO.setTitle("Whiplash");
        movieSearchItemDTO.setType("Movie");
        movieSearchItemDTO.setYear("2014");
        movieSearchItemDTO.setImdbID("1");
    }

    @AfterEach
    public void tearDown(){
        mockMvc = null;
    }

    @Test
    public void test_omdbMultiSearch() throws Exception {



        List<OmdbMovieSearchItemDTO> testList = new ArrayList<>();
        testList.add(movieSearchItemDTO);

        when(mockOmdbService.multiSearch(any(String.class))).thenReturn(testList);

        mockMvc.perform(MockMvcRequestBuilders.get("/omdb/multi-search/" + movieSearchItemDTO.getTitle())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    public void test_omdbSearchByTitle() throws Exception {

        when(mockOmdbService.searchByTitle(any(String.class))).thenReturn(movieDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/omdb/title-search/" + movieDTO.getTitle())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


//    @Test
//    public void test_omdbSearchByImdbId() throws Exception {
//
//        when(mockOmdbService.searchByImdbId(any(String.class))).thenReturn(movieDTO);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/omdb/imdbSearch/" + movieSearchItemDTO.getImdbID())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//    }

}
