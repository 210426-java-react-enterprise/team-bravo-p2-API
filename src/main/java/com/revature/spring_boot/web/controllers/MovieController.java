package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.services.MovieService;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-all")
    public List<MovieDTO> getAllMovies(){
        List<MovieDTO> movieDTOList = movieService.getMovieList().stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
        return movieDTOList;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/save")
    @ResponseBody
    public MovieDTO saveNewMovie(@RequestBody @Valid MovieDTO newMovie){

        MovieDTO movieDTO = new MovieDTO(movieService.saveNewMovie(newMovie));

        return movieDTO;
    }

}
