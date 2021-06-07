package com.revature.spring_boot.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get/{movieCollectionsId")
    public Optional<MovieCollections> getAllMovieCollections(@PathVariable int movieCollectionsId) {
        return movieCollectionsRepo.findById(movieCollectionsId);
    }

}