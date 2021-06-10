package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.services.MovieService;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/add")
    public void addMovie(@RequestBody Movies movie){
        movieService.addMovie(movie);
    }


    //TODO: make this more efficient
    @DeleteMapping(consumes = APPLICATION_JSON_VALUE, value = "/delete")
    public void deleteMovieById(@RequestBody Movies movie){

        //first, get the id (which is set to 0 by default)
        List<MovieDTO> dbMovies = getAllMovies();

        for(MovieDTO m : dbMovies){
            if(m.getTitle().equals(movie.getTitle())){
                movie.setMovieId(m.getId());
                break;
            }
        }

        //now that id isn't 0, do deletion
        if(movieService.deleteMovieById(movie)){//confirms id is valid
            logger.info("Movie " + movie.getTitle() + " successfully deleted!");
        }else{
            logger.warn("Invalid Id " + movie.getMovieId() + "!  Cancelling deletion!");
        }
    }

}
