package com.revature.spring_boot.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 9:38 PM
 * Description: {Insert Description}
 */
public class OmdbSearchDTO {

    @JsonProperty("Response")
    private String resp;

    @JsonProperty("Search")
    private List<OmdbMovieSearchItemDTO> searchResults;

    public OmdbSearchDTO() {
        super();
    }

    public List<OmdbMovieSearchItemDTO> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(String resp, List<OmdbMovieSearchItemDTO> searchResults) {
        this.resp = resp;
        this.searchResults = searchResults;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public void setSearchResults(List<OmdbMovieSearchItemDTO> searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public String toString() {
        return "OmdbSearchDTO{" +
                "resp='" + resp + '\'' +
                ", searchResults=" + searchResults +
                '}';
    }
}
