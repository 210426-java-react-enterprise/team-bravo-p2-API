package com.revature.spring_boot.services;

import com.revature.spring_boot.models.MovieCollections;
import com.revature.spring_boot.repos.MovieCollectionsRepository;
import com.revature.spring_boot.web.dtos.MovieCollectionInsertDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class MovieCollectionServiceUnitTestSuite {
    private MovieCollectionService sut;
    private MovieCollectionsRepository mockCollRepo;

    @Before
    public void seUp(){
        mockCollRepo = mock(MovieCollectionsRepository.class);
        sut = new MovieCollectionService(mockCollRepo);
    }

    @After
    public void tearDown(){
        sut = null;
        mockCollRepo = null;

    }

    @Test
    public void test_getAllMovieCollections(){
        List<MovieCollections> movieCollections = new LinkedList<>();
        when(mockCollRepo.findAll()).thenReturn(movieCollections);

        sut.getAllMovieCollections();
    }

    @Test
    public void test_getMovieCollectionByID(){
        MovieCollections movieCollections = new MovieCollections();
        when(mockCollRepo.findById(anyInt())).thenReturn(Optional.of(movieCollections));

        sut.getMovieCollectionsById(1);
    }

    @Test
    public void test_saveCollection(){
        MovieCollectionInsertDTO collection = new MovieCollectionInsertDTO();
        collection.setOwned(1);
        collection.setWatched(2);
        collection.setUserRating(1);
        collection.setUserDescrip("test");
        collection.setTradable(1);
        collection.setCollectionInfoId(1);
        collection.setMovieID(1);

        sut.saveCollection(collection);
    }

    @Test
    public void test_updateMovieCollectionById(){
        int movieCollectionsId = 50;
        MovieCollections movieCollections = new MovieCollections();
        movieCollections.setCollId(50);
        mockCollRepo.save(movieCollections);

        when(mockCollRepo.findById(anyInt())).thenReturn(Optional.of(movieCollections));

        sut.updateMovieCollectionById(movieCollectionsId, movieCollections);
    }

    @Test
    public void deleteCollectionById(){
        MovieCollections movieCollections = new MovieCollections();
        movieCollections.setCollId(50);
        when(mockCollRepo.findById(50)).thenReturn(Optional.of(movieCollections));

        sut.deleteCollectionById(50);
    }




}
