package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.DataSourceException;
import com.revature.spring_boot.exceptions.InvalidRequestException;
import com.revature.spring_boot.exceptions.ResourceNotFoundException;
import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 9:58 PM
 * Description: {Insert Description}
 */

@Service
@Transactional
public class MovieCollectionService {

    private MovieCollectionsRepository collectionInfoRepo;

    @Autowired
    public MovieCollectionService(MovieCollectionsRepository collectionInfoRepo) {
        this.collectionInfoRepo = collectionInfoRepo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<MovieCollections> getAllMovieCollections() {
        return collectionInfoRepo.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public MovieCollections getMovieCollectionsById(int id) {

        if (id <= 0)
            throw new InvalidRequestException("Invalid id value provided!");

        try {
            return collectionInfoRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        } catch (Exception e) {
            throw new DataSourceException(e);
        }

    }

    public ResponseEntity<String> updateMovieCollection(MovieCollections movieRequest) {

        Optional<MovieCollections> movieCollections = collectionInfoRepo.findById(movieRequest.getMovies().getMovieId());
        if(movieCollections.isPresent()) {
            movieCollections.get().setUserRating(movieRequest.getUserRating());
            movieCollections.get().setTradeable(movieRequest.getTradeable());
            movieCollections.get().setUserComment(movieRequest.getUserComment());
            movieCollections.get().setWatched(movieRequest.getWatched());
            collectionInfoRepo.save(movieCollections.get());
            return new ResponseEntity<String>("Your collection has been updated successfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Sorry, we cannot find that collection item"+ movieRequest.getMovies().getMovieId(), HttpStatus.BAD_REQUEST);

    }

}
