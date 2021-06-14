package com.revature.spring_boot.web.controllers;

import com.google.gson.Gson;
import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.services.MovieService;
import com.revature.spring_boot.web.dtos.MovieDTO;
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

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MovieControllerTest {

    private MockMvc mockMvc;

    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    private AccountRepository accountRepo;

    //private MovieController movieController;
    private MovieService mockMovieService;

    private MovieDTO movieDTO1;
    private List<MovieDTO> movieDTOList;
    private Movies movie1;
    private List<Movies> moviesList;

    @Autowired
    public MovieControllerTest(WebApplicationContext webContext, TokenGenerator tokenGenerator, AccountRepository accountRepo) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
        this.accountRepo = accountRepo;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        this.mockMovieService = mock(MovieService.class);

        movieDTO1 = new MovieDTO();
        movieDTO1.setId(1);
        movieDTO1.setTitle("Whiplash");
        movieDTO1.setLengthMin(106);
        movieDTO1.setMpaaRating("R");
        movieDTO1.setYear(2014);
        movieDTO1.setProdCompany("Blumhouse");
        movieDTO1.setGenre("Drama, Music");
        movieDTO1.setDescription("About a drummer and his teacher.");

        movieDTOList = new ArrayList<>();
        movieDTOList.add(movieDTO1);

        movie1 = new Movies();
        movie1.setMovieId(1);
        movie1.setTitle("Whiplash");
        movie1.setLengthMin(106);
        movie1.setMpaaRating("R");
        movie1.setYear(2014);
        movie1.setProdCompany("Blumhouse");
        movie1.setGenre("Drama, Music");
        movie1.setDescription("About a drummer and his teacher.");

        moviesList = new ArrayList<>();
        moviesList.add(movie1);
    }

    @AfterEach
    public void teardown(){

        movieDTO1 = null;
        movie1 = null;
        movieDTOList = null;
        moviesList = null;
        mockMovieService = null;
        mockMvc = null;

    }


    @Test
    public void test_constructor(){
        MovieController movieController = new MovieController(mockMovieService);
        movieController = null;
    }


    @Test
    public void test_getAllMovies() throws Exception {

        when(mockMovieService.getMovieList()).thenReturn(moviesList);

        mockMvc.perform(MockMvcRequestBuilders.get("/movie/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void test_saveNewMovie() throws Exception {

        when(mockMovieService.saveNewMovie(any(MovieDTO.class))).thenReturn(movie1);

        Gson gson = new Gson();
        String jsonLine = gson.toJson(movieDTO1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/movie/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLine))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


}
