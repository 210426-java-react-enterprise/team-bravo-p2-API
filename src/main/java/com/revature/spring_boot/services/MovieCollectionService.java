package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.DataSourceException;
import com.revature.spring_boot.exceptions.InvalidRequestException;
import com.revature.spring_boot.exceptions.ResourceNotFoundException;
import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.web.dtos.MovieCollectionInsertDTO;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    public MovieCollectionInsertDTO saveCollection(MovieCollectionInsertDTO collection){

        collectionInfoRepo.insertMovieCollection(collection.getOwned(), collection.getWatched(),
                collection.getUserRating(), collection.getUserDescrip(), collection.getTradable(),
                collection.getCollectionInfoId(), collection.getMovieID());

        return collection; }

    @Transactional(propagation = Propagation.SUPPORTS)
    public MovieCollections updateMovieCollectionById(int movieCollectionsId, MovieCollections movieCollect) {

        if(collectionInfoRepo.findById(movieCollectionsId).isPresent()) {
            MovieCollections existingCollectionItem = collectionInfoRepo.findById(movieCollectionsId).get();

            existingCollectionItem.setUserComment(movieCollect.getUserComment());
            existingCollectionItem.setTradeable(movieCollect.getTradeable());
            existingCollectionItem.setWatched(movieCollect.getWatched());
            existingCollectionItem.setUserRating(movieCollect.getUserRating());

            MovieCollections updatedCollectionItem = collectionInfoRepo.save(existingCollectionItem);

            return updatedCollectionItem;
    }
        return null;
    }


//return of Optional may be better, to avoid null pointer exceptions.
//    public ResponseEntity<String> updateMovieCollections(int movieCollectionsId, MovieCollections movieRequest) {
//
//        Optional<MovieCollections> movieCollections = collectionInfoRepo.findById(movieRequest.getMovies().getMovieId());
//        if(movieCollections.isPresent()) {
//            movieCollections.get().setUserRating(movieRequest.getUserRating());
//            movieCollections.get().setTradeable(movieRequest.getTradeable());
//            movieCollections.get().setUserComment(movieRequest.getUserComment());
//            movieCollections.get().setWatched(movieRequest.getWatched());
//            collectionInfoRepo.save(movieCollections.get());
//            return new ResponseEntity<String>("Your collection has been updated successfully", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<String>("Unfortunately, we cannot find that collection item"+ movieRequest.getMovies().getMovieId(), HttpStatus.BAD_REQUEST);
//
//    }


    public void deleteCollectionById(int movieCollectionsId) {
        MovieCollections existingItem = collectionInfoRepo.findById(movieCollectionsId)
                .orElseThrow(() -> new ResourceNotFoundException());

        collectionInfoRepo.delete(existingItem);
    }



    }

