package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.Movies;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:48 PM
 * Description: {Insert Description}
 */
public class MovieDTO {

    private int id;

    @NotEmpty
    private String title;

    //@NotEmpty
    private int year;

    @NotEmpty
    private String mpaaRating;

    //@NotEmpty
    private int lengthMin;

    @NotEmpty
    private String genre;

    @NotEmpty
    private String description;

    @NotEmpty
    private String prodCompany;

    private String imgUrl;

    public MovieDTO() {
        super();
    }

    public MovieDTO(Movies movie) {
        this.id = movie.getMovieId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.mpaaRating = movie.getMpaaRating();
        this.lengthMin = movie.getLengthMin();
        this.genre = movie.getGenre();
        this.description = movie.getDescription();
        this.prodCompany = movie.getProdCompany();
        if (movie.getImgUrl() != null) {
            this.imgUrl = movie.getImgUrl();
        }
    }

    public MovieDTO(OmdbMovieDTO movie) {
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.mpaaRating = movie.getMpaaRating();
        this.lengthMin = movie.getLengthMin();
        this.genre = movie.getGenre();
        this.description = movie.getDescription();
        this.prodCompany = movie.getProdCompany();
        this.imgUrl = movie.getImgUrl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setYear(int year) {
        this.year = year;
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

    public void setLengthMin(int lengthMin) {
        this.lengthMin = lengthMin;
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

    public String getProdCompany() {
        return prodCompany;
    }

    public void setProdCompany(String prodCompany) {
        this.prodCompany = prodCompany;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
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
