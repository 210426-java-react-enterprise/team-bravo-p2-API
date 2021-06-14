package com.revature.spring_boot.services;

import com.revature.spring_boot.models.Movies;
import com.revature.spring_boot.repos.MovieRepository;
import com.revature.spring_boot.web.dtos.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieRepository movieRepository2){
        this.movieRepository = movieRepository;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Movies> getMovieList(){
        return movieRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Movies saveNewMovie(MovieDTO newMovie) {

        Movies returnValue = new Movies(newMovie);

        if (existCheck(newMovie) == null) {
            movieRepository.save(returnValue);
        }

        returnValue = existCheck(newMovie);

        return returnValue;
    }

    private Movies existCheck(MovieDTO movie) {

        List<Movies> existCheck = movieRepository.exists(movie.getTitle(), movie.getYear(), movie.getMpaaRating(),
                movie.getLengthMin(), movie.getGenre(), movie.getDescription(), movie.getProdCompany());

        if (existCheck.size() == 0) {
            return null;
        }

        return existCheck.get(0);
    }

}
