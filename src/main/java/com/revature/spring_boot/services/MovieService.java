package com.revature.spring_boot.services;

import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.repos.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Movies> getMovieList(){
        return movieRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMovie(Movies movie){
        movieRepository.save(movie);
    }

}
