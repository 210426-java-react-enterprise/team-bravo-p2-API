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

@Component
public class OmdbTemplates {

    private String apiUrl = "http://www.omdbapi.com/?apikey=8fb2906&";

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
