package com.revature.spring_boot.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/7/2021
 * Time: 11:51 AM
 * Description: {Insert Description}
 */

@RestController
@RequestMapping("/movieCollections")
public class MovieCollectionsController {

    private Logger logger = LoggerFactory.getLogger(MovieCollectionsController.class);
    private MovieCollectionsRepository movieCollectionsRepo;

    @Autowired
    public MovieCollectionsController(MovieCollectionsRepository movieCollectionsRepo) {
        this.movieCollectionsRepo = movieCollectionsRepo;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<MovieCollections> getAllMovieCollections() {
        return movieCollectionsRepo.findAll();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get/{movieCollectionsId}")
    public Optional<MovieCollections> getAllMovieCollections(@PathVariable int movieCollectionsId) {
        return movieCollectionsRepo.findById(movieCollectionsId);
    }


    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/update")
    public ResponseEntity<String> updateMovieCollections(@RequestBody MovieCollections movieRequest) {
        Optional<MovieCollections> movieCollections = movieCollectionsRepo.findById(movieRequest.getMovieId());
            if(movieCollections.isPresent()) {
                movieCollections.get().setUserRating(movieRequest.getUserRating());
                movieCollections.get().setTradeable(movieRequest.getTradeable());
                movieCollections.get().setUserComment(movieRequest.getUserComment());
                movieCollections.get().setWatched(movieRequest.getWatched());
                movieCollectionsRepo.save(movieCollections.get());
                return new ResponseEntity<String>("Your collection has been updated successfully", HttpStatus.OK);
            }

            return new ResponseEntity<String>("Sorry, we cannot find that collection item"+ movieRequest.getMovieId(), HttpStatus.BAD_REQUEST);
    }
}