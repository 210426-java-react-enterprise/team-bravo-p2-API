package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.services.MovieCollectionService;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import com.revature.spring_boot.web.security.TokenParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    private TokenParser tokenParser;

    @Autowired
    public MovieCollectionsController(MovieCollectionService movieCollectionService, TokenParser tokenParser) {
        this.movieCollectionService = movieCollectionService;
        this.tokenParser = tokenParser;
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/save")
    @ResponseBody
    public MovieCollectionsDTO createMovieCollection(@RequestBody @Valid MovieCollectionsDTO newCollection){
       MovieCollectionsDTO savedItem = new MovieCollectionsDTO(movieCollectionService.saveCollection(newCollection));
    return savedItem;
    }



    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<MovieCollectionsDTO> getAllMovieCollections() {
        List<MovieCollectionsDTO> movieCollections = movieCollectionService.getAllMovieCollections()
                .stream()
                .map(MovieCollectionsDTO::new)
                .collect(Collectors.toList());

        return movieCollections;

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getByID")
    public MovieCollectionsDTO getMovieCollectionsById(@PathVariable int movieCollectionsId) {
        MovieCollectionsDTO movCollDTO = new MovieCollectionsDTO(movieCollectionService.getMovieCollectionsById(movieCollectionsId));

        return movCollDTO;
    }


    @PutMapping("/update/{id}")
    public MovieCollections updateItems(@PathVariable(value="id") int id, @RequestBody MovieCollectionsDTO updatedItem){

        MovieCollections item = movieCollectionService.updateItem(id, updatedItem);

        return item;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteMovieCollection(@PathVariable(value = "id") int id) {
        movieCollectionService.deleteCollectionById(id);

    }
}