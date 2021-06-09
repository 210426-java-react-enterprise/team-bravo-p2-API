package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.services.MovieCollectionService;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    private MovieCollectionService movieCollectionService;

    @Autowired
    public MovieCollectionsController(MovieCollectionService movieCollectionService) {
        this.movieCollectionService = movieCollectionService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<MovieCollectionsDTO> getAllMovieCollections() {

        List<MovieCollectionsDTO> movieCollections = movieCollectionService.getAllMovieCollections()
                .stream()
                .map(MovieCollectionsDTO::new)
                .collect(Collectors.toList());

        return movieCollections;

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get/{movieCollectionsId}")
    public MovieCollectionsDTO getMovieCollectionsById(@PathVariable int movieCollectionsId) {

        MovieCollectionsDTO movCollDTO = new MovieCollectionsDTO(movieCollectionService.getMovieCollectionsById(movieCollectionsId));

        return movCollDTO;
    }


    // TODO: This will need some testing...
    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/update")
    public ResponseEntity<String> updateMovieCollections(@RequestBody MovieCollections movieRequest) {
        return movieCollectionService.updateMovieCollection(movieRequest);
    }
}