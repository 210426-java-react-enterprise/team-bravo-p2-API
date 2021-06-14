package com.revature.spring_boot.rest_templates;

import com.revature.spring_boot.web.dtos.OmdbMovieDTO;
import com.revature.spring_boot.web.dtos.OmdbSearchDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 10:21 PM
 * Description: {Insert Description}
 */

/**
 *  Class used to make third party calls to the OMDB API
 */
@Component
public class OmdbTemplates {

    private String apiUrl = "http://www.omdbapi.com/?apikey=8fb2906&";

    /**
     *
     *  Does a general search by movie title returning an item containing a list of omdb formatted movies
     *
     * @param title
     * @return
     */
    public OmdbSearchDTO omdbMultiSearch(String title){

        OmdbSearchDTO returnVal = new OmdbSearchDTO();

        returnVal.setResp("False");

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity requestConfig = new HttpEntity(httpHeaders);

            ResponseEntity<OmdbSearchDTO> response = restTemplate.exchange(apiUrl + "s=" + title, HttpMethod.GET, requestConfig, OmdbSearchDTO.class);

            returnVal = response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnVal;

    }

    /**
     *
     * Brings back the first occurrence in a title search from OMDB
     *
     * @param title
     * @return
     */
    public OmdbMovieDTO searchOmdbByTitle(String title) {

        OmdbMovieDTO returnVal = new OmdbMovieDTO();

        returnVal.setResp("False");

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity requestConfig = new HttpEntity(httpHeaders);

            ResponseEntity<OmdbMovieDTO> response = restTemplate.exchange(apiUrl + "t=" + title, HttpMethod.GET, requestConfig, OmdbMovieDTO.class);

            returnVal = response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnVal;

    }

    /**
     *
     *  Queries the OMDB API using the most unique identifier best to be used in tandem with multisearch so the user gets the correct movie they select
     *
     * @param imdbId
     * @return
     */
    public OmdbMovieDTO searchOmdbByImdbId(String imdbId) {

        OmdbMovieDTO returnVal = new OmdbMovieDTO();

        returnVal.setResp("False");

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity requestConfig = new HttpEntity(httpHeaders);

            ResponseEntity<OmdbMovieDTO> response = restTemplate.exchange(apiUrl + "i=" + imdbId, HttpMethod.GET, requestConfig, OmdbMovieDTO.class);

            returnVal = response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnVal;

    }

}
