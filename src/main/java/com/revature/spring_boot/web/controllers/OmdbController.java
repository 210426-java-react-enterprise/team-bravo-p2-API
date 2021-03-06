package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.services.OmdbService;
import com.revature.spring_boot.web.dtos.MovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieDTO;
import com.revature.spring_boot.web.dtos.OmdbMovieSearchItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 11:35 PM
 * Description: Controller class exposing omdb based endpoints
 */

@RestController
@RequestMapping("/omdb")
public class OmdbController {

    private Logger logger = LoggerFactory.getLogger(OmdbController.class);
    private OmdbService omdbService;

    @Autowired
    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    /**
     * Allows the user to search omdb and get multiple movie possibilities
     * @param title
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/multi-search/{title}")
    public List<OmdbMovieSearchItemDTO> omdbMultiSearch(@PathVariable String title) {
        return omdbService.multiSearch(title);
    }

    /**
     * Allows the suer to search omdb and get the first occurrence of a title
     * @param title
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/title-search/{title}")
    public MovieDTO omdbSearchByTitle(@PathVariable String title) {
        return omdbService.searchByTitle(title);
    }

    /**
     * allows the user to search omdb by imdb id for the most relevant match
     * @param imdbId
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/imdb-search/{imdbId}")
    public MovieDTO omdbSearchByImdbId(@PathVariable String imdbId) {
        return omdbService.searchByImdbId(imdbId);
    }

}
