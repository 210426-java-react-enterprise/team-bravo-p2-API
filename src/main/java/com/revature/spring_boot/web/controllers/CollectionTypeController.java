package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.services.CollectionTypeService;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/collectionType")
public class CollectionTypeController {

    private Logger logger = LoggerFactory.getLogger(CollectionType.class);
    private CollectionTypeService collectionTypeService;

    @Autowired
    public CollectionTypeController(CollectionTypeService collectionTypeService) {
        this.collectionTypeService = collectionTypeService;
    }

//    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/save")
//    public CollectionTypeDTO collectionTypeDTO(@RequestBody CollectionTypeDTO collectionTypeDTO) {
//
//    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<CollectionTypeDTO> getAllCollectionTypes() {
        List<CollectionTypeDTO> collectionTypes = collectionTypeService.getAllCollectionTypes()
                .stream()
                .map(type -> new CollectionTypeDTO(type))
                .collect(Collectors.toList());

        System.out.println(collectionTypes.toString());

        return collectionTypes;
    }
}
