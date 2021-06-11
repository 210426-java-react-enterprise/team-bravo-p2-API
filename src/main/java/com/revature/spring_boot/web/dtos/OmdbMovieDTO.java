package com.revature.spring_boot.web.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.spring_boot.models.Movies;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 8:37 PM
 * Description: {Insert Description}
 */
public class OmdbMovieDTO {

    private String title;
    private int year;
    private String mpaaRating;
    private int lengthMin;
    private String genre;
    private String description;
    private String type;
    private String prodCompany;
    private String lengthString;
    private String yearString;
    private String resp;

    public OmdbMovieDTO() {
        super();
    }

    @JsonCreator
    public OmdbMovieDTO(
                   @JsonProperty("Title") String title,
                   @JsonProperty("Year") String year,
                   @JsonProperty("Rated") String mpaaRating,
                   @JsonProperty("Runtime") String lengthString,
                   @JsonProperty("Genre") String genre,
                   @JsonProperty("Plot") String description,
                   @JsonProperty("Type") String type,
                   @JsonProperty("Production")String prodCompany,
                   @JsonProperty("Response")String resp
    ) {
        this.title = title;
        this.yearString = year;
        this.mpaaRating = mpaaRating;
        this.lengthString = lengthString;
        this.genre = genre;
        this.description = description;
        this.type = type;
        this.prodCompany = prodCompany;
        this.resp = resp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(String yearString) {
        this.year = Integer.parseInt(yearString.substring(0,4));
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public int getLengthMin() {
        return lengthMin;
    }

    public void setLengthMin(String length) {
        this.lengthMin = Integer.parseInt(length.split(" ")[0]);;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProdCompany() {
        return prodCompany;
    }

    public void setProdCompany(String prodCompany) {
        this.prodCompany = prodCompany;
    }

    public String getLengthString() {
        return lengthString;
    }

    public void setLengthString(String lengthString) {
        this.lengthString = lengthString;
    }

    public String getYearString() {
        return yearString;
    }

    public void setYearString(String yearString) {
        this.yearString = yearString;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return "OmdbDTO{" +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", lengthMin=" + lengthMin +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", prodCompany='" + prodCompany + '\'' +
                '}';
    }

}
