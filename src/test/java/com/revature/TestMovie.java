package com.revature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.repos.MovieRepository;
import com.revature.spring_boot.services.MovieService;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

import com.revature.spring_boot.web.controllers.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//https://stackoverflow.com/questions/64672608/nullpointerexception-in-junit-5-mockbean

@ExtendWith(SpringExtension.class)//supposed to resolve nullpointerexception
@WebMvcTest(MovieController.class)
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc//this may not work as intended
public class TestMovie {

    @MockBean
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MovieController movieController;

    @MockBean
    @InjectMocks
    MovieService movieService;

    @MockBean
    @Mock
    MovieRepository movieRepository;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public void setup(){
//        movieRepository = Mockito.mock(MovieRepository.class);
//        movieService = new MovieService(movieRepository);

        //MockitoAnnotations.openMocks(this);
        movieService = new MovieService(movieRepository);

    }

    @AfterAll
    public void tearDown(){
        mockMvc = null;
        movieRepository = null;
        movieService = null;
        movieController = null;
    }

    @Test/*(expected = NullPointerException.class)*/
    public void getMovieList_test() throws Exception {
        //MovieDTO movie1 = new MovieDTO();
        Movies movie1 = new Movies();
        //movie1.setId(1);
        movie1.setMovieId(1);
        movie1.setTitle("Whiplash");
        movie1.setLengthMin(106);
        movie1.setMpaaRating("R");
        movie1.setYear(2014);
        movie1.setProdCompany("Blumhouse");
        movie1.setGenre("Drama, Music");
        movie1.setDescription("About a drummer and his teacher.");

        MovieDTO movieDTO1 = new MovieDTO();
        movieDTO1.setId(1);
        movieDTO1.setTitle("Whiplash");
        movieDTO1.setLengthMin(106);
        movieDTO1.setMpaaRating("R");
        movieDTO1.setYear(2014);
        movieDTO1.setProdCompany("Blumhouse");
        movieDTO1.setGenre("Drama, Music");
        movieDTO1.setDescription("About a drummer and his teacher.");

        //List<MovieDTO> movieList = new ArrayList<>();
        //movieList.add(movie1);

        //movieService = new MovieService(movieRepository);

        when(movieService.addMovie(any(Movies.class))).thenReturn(movie1);//nullpointerexception here is fixed

        //but now mockmvc has it!
        mockMvc.perform(MockMvcRequestBuilders.post("/add").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(movieDTO1))//movie1 set here
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Whiplash"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(2014))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mpaa_rating").value("R"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length_min").value(106))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("Drama, Music"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descrip").value("About a drummer and his teacher."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prod_company").value("Blumhouse"));


    }

}
