package com.revature.spring_boot.web.dtos;

import com.revature.spring_boot.models.CollectionType;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 6:15 PM
 * Description: {Insert Description}
 */
public class CollectionTypeDTO {

    private int id;

    @NotEmpty
    private String mediumType;

    public CollectionTypeDTO() {
        super();
    }

    public CollectionTypeDTO(CollectionType type) {
        this.id = type.getId();
        this.mediumType = type.getMediumType();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType;
    }

    @Override
    public String toString() {
        return "CollectionTypeDTO{" +
                "id=" + id +
                ", mediumType='" + mediumType + '\'' +
                '}';
    }
}
