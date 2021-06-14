package com.revature.spring_boot.services;


import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.repos.MovieRepository;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class MovieServiceUnitTest {
    private MovieService sut;
    private MovieRepository mockMovieRepo;

    @Before
    public void setUp(){
        mockMovieRepo = mock(MovieRepository.class);
        sut = new MovieService(mockMovieRepo);

    }

    @After
    public void tearDown(){
        sut = null;
        mockMovieRepo = null;
    }

    @Test
    public void test_getMovieList(){
        sut.getMovieList();
    }

    @Test
    public void test_saveNewMovie(){
        MovieDTO newMovie = new MovieDTO();
        newMovie.setDescription("Horror");
        newMovie.setGenre("Thriller");
        newMovie.setId(60);
        newMovie.setTitle("Scarface");
        newMovie.setYear(1983);
        newMovie.setMpaaRating("Good");
        Movies returnValue = new Movies(newMovie);
        List<Movies> existCheck= new ArrayList<>();

        //when(sut.existCheck(any())).thenReturn(null);
        when(mockMovieRepo
                .exists("test", 1, "good", 1, "good", "test", "company"))
                .thenReturn(existCheck);
        sut.saveNewMovie(newMovie);
    }

}
