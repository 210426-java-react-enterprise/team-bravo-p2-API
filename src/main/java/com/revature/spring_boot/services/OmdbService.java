package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.InvalidRequestException;
import com.revature.spring_boot.exceptions.ResourceNotFoundException;
import com.revature.spring_boot.rest_templates.OmdbTemplates;
import com.revature.spring_boot.web.dtos.MovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieSearchItemDTO;
import com.revature.spring_boot.web.dtos.OmdbSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 10:51 PM
 * Description: {Insert Description}
 */

@Service
public class OmdbService {

    private OmdbTemplates omdbTemplates;

    @Autowired
    public OmdbService(OmdbTemplates omdbTemplates) {
        this.omdbTemplates = omdbTemplates;
    }

    public List<OmdbMovieSearchItemDTO> multiSearch(String title) {

        if (!isValidInput(title)) {
            throw new InvalidRequestException("An invalid title was provided.");
        }

        title = prepareInput(title);

        OmdbSearchDTO omdbSearchDTO = omdbTemplates.omdbMultiSearch(title);

        if (omdbSearchDTO.getResp() == "False") {
            throw new ResourceNotFoundException();
        }

        List<OmdbMovieSearchItemDTO> returnValue = omdbSearchDTO.getSearchResults();

        returnValue = includeOnlyMovies(returnValue);

        return returnValue;
    }

    public MovieDTO searchByTitle(String title) {

        if (!isValidInput(title)) {
            throw new InvalidRequestException("An invalid title was provided.");
        }

        title = prepareInput(title);

        OmdbMovieDTO omdbMovieDTO = omdbTemplates.searchOmdbByTitle(title);

        if (omdbMovieDTO.getResp() == "False") {
            throw new ResourceNotFoundException();
        }

        if (!movieCheck(omdbMovieDTO)){};

        MovieDTO movieDTO = packageAsMovieDTO(omdbMovieDTO);

        return movieDTO;
    }

    public MovieDTO searchByImdbId(String imdbId) {

        if (!isValidInput(imdbId)) {
            throw new InvalidRequestException("An invalid imdb id was provided.");
        }

        imdbId = prepareInput(imdbId);

        OmdbMovieDTO omdbMovieDTO = omdbTemplates.searchOmdbByImdbId(imdbId);

        if (omdbMovieDTO.getResp() == "False") {
            throw new ResourceNotFoundException();
        }

        if (omdbMovieDTO.getResp() == "False") {
            throw new ResourceNotFoundException();
        }

        if (!movieCheck(omdbMovieDTO)){};

        MovieDTO movieDTO = packageAsMovieDTO(omdbMovieDTO);

        return movieDTO;
    }

    private OmdbMovieDTO genreSlim(OmdbMovieDTO movie) {

        if(movie.getGenre().contains(",")) {
            movie.setGenre(movie.getGenre().split(",")[0]);
        }

        return movie;

    }

    private List<OmdbMovieSearchItemDTO> includeOnlyMovies(List<OmdbMovieSearchItemDTO> multiSearchResult) {

        List<OmdbMovieSearchItemDTO> removalList = new ArrayList<>();

        for (OmdbMovieSearchItemDTO omsid : multiSearchResult) {

            if (!omsid.getType().equals("movie")) {
                removalList.add(omsid);
            }

        }

        multiSearchResult.removeAll(removalList);

        return multiSearchResult;

    }

    private boolean movieCheck(OmdbMovieDTO movie) {

        if (!movie.getType().equals("movie")) {
            throw new ResourceNotFoundException();
        }

        return true;

    }

    private MovieDTO packageAsMovieDTO(OmdbMovieDTO movie) {

        movie.setLengthMin(movie.getLengthString());
        movie.setYear(movie.getYearString());
        genreSlim(movie);

        MovieDTO movieDTO = new MovieDTO(movie);

        return movieDTO;
    }


    private String prepareInput(String input) {

        input.trim();

        input.replace(' ', '+');

        return input;
    }

    private boolean isValidInput(String input) {

        if (input.length() == 0) {
            return false;
        }

        input = input.trim();

        if (input.length() == 0 || input.length() >= 208) {
            return false;
        }

        return true;
    }

}
