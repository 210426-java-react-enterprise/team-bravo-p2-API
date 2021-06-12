package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.DataSourceException;
import com.revature.spring_boot.exceptions.InvalidRequestException;
import com.revature.spring_boot.exceptions.ResourceNotFoundException;
import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import com.revature.spring_boot.web.dtos.MovieCollectionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
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
    public MovieCollections saveCollection(MovieCollectionsDTO collection){
       MovieCollections saveCollection = new MovieCollections(collection);
       collectionInfoRepo.save(saveCollection);

    return saveCollection; }


    public MovieCollections updateItem(int id, MovieCollectionsDTO movieCollectionUpdate) {
        MovieCollections updatepost = collectionInfoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
            updatepost.setUserRating(movieCollectionUpdate.getUserRating());
            updatepost.setWatched(movieCollectionUpdate.getWatched());
            updatepost.setOwned(movieCollectionUpdate.getOwned());
            updatepost.setTradeable(movieCollectionUpdate.getTradeable());
            updatepost.setUserComment(movieCollectionUpdate.getUserDescrip());
            return collectionInfoRepo.save(updatepost);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteCollectionById(int movieCollectionsId) {
        MovieCollections existingItem = collectionInfoRepo.findById(movieCollectionsId)
                .orElseThrow(() -> new ResourceNotFoundException());

        collectionInfoRepo.delete(existingItem);
    }



}

