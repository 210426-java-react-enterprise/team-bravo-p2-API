package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.services.MovieCollectionService;
import com.revature.spring_boot.web.dtos.MovieCollectionInsertDTO;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import com.revature.spring_boot.web.security.TokenParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;
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

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-all")
    public List<MovieCollectionsDTO> getAllMovieCollections() {
        List<MovieCollectionsDTO> movieCollections = movieCollectionService.getAllMovieCollections()
                .stream()
                .map(MovieCollectionsDTO::new)
                .collect(Collectors.toList());

        return movieCollections;

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-by-id/{id}")
    public MovieCollectionsDTO getMovieCollectionsById(@PathVariable("id") int movieCollectionsId) {
        MovieCollectionsDTO movCollDTO = new MovieCollectionsDTO(movieCollectionService.getMovieCollectionsById(movieCollectionsId));

        return movCollDTO;
    }


//    // TODO: This will need some testing...
//    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/update")
//    public ResponseEntity<String> updateMovieCollections(@RequestBody MovieCollections movieRequest) {
//        return movieCollectionService.updateMovieCollection(movieRequest);
//    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, value = "/update/{movieCollectionsId}")
    public MovieCollectionsDTO updateMovieCollectionById(@PathVariable(value="movieCollectionsId") int movieCollectionsId,
                                                                      @RequestBody MovieCollectionInsertDTO movieCollect){
       MovieCollectionsDTO updatedMovCollDTO = new MovieCollectionsDTO(movieCollectionService.updateMovieCollectionById(movieCollectionsId, movieCollect));
       return  updatedMovCollDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/save")
    @ResponseBody
    public MovieCollectionInsertDTO createMovieCollection(@RequestBody @Valid MovieCollectionInsertDTO newCollection){
        MovieCollectionInsertDTO savedItem = movieCollectionService.saveCollection(newCollection);

        return savedItem;
    }


    @DeleteMapping(value = "/delete/{movieCollectionsId}")
    public void deleteMovieCollection(@PathVariable(value = "movieCollectionsId") int movieCollectionsId) {

        movieCollectionService.deleteCollectionById(movieCollectionsId);

    }
}