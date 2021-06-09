package com.revature.spring_boot.controllers;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public MovieCollections updateMovieCollections(@RequestBody MovieCollections updateRequest) {

        if (movieCollectionsRepo.findById(updateRequest.getMovieId()).isPresent()) {
            MovieCollections existingItem = movieCollectionsRepo.findById(updateRequest.getMovieId()).get();

            existingItem.setWatched(updateRequest.getWatched());
            existingItem.setTradeable(updateRequest.getTradeable());
            existingItem.setUserRating(updateRequest.getUserRating());
            existingItem.setUserComment(updateRequest.getUserComment());

            MovieCollections updatedItem = movieCollectionsRepo.save(existingItem);

            return updatedItem;
        } else {
            return null;
        }


    }

    @DeleteMapping(value = "deleteItem/{movieCollectionsId}")
    public void deleteMovieCollection(@PathVariable int movieCollectionsId) {

        Optional<MovieCollections> existingItem = movieCollectionsRepo.findById(movieCollectionsId);
        if (existingItem.isPresent()) {
            movieCollectionsRepo.delete(existingItem.get());
        }
    }
}


//    public ResponseEntity<String> deleteMovieCollections(@PathVariable int movieId){
//        Optional<MovieCollections> existingItem = movieCollectionsRepo.findById(movieId);
//        if(existingItem.isPresent()) {
//            movieCollectionsRepo.delete(existingItem.get());
//            return new ResponseEntity<String>("Movie item has been deleted successfully", HttpStatus.OK);
//        }
//        return new ResponseEntity<String>("Cannot find that collection item" + movieId, HttpStatus.BAD_REQUEST);
//    }
//}