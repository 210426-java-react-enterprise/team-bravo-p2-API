package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.services.MovieService;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class);
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<MovieDTO> getAllMovies(){
        List<MovieDTO> movieDTOList = movieService.getMovieList().stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
        return movieDTOList;
    }

}
