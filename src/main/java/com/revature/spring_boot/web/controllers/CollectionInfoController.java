package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.services.CollectionInfoService;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/collection")
public class CollectionInfoController {
    
    private Logger logger = LoggerFactory.getLogger(CollectionInfoController.class);

    private CollectionInfoService collectionInfoService;

    @Autowired
    public CollectionInfoController(CollectionInfoService collectionInfoService){
        this.collectionInfoService = collectionInfoService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<CollectionInfoDTO> getAllCollections() {

        List<CollectionInfoDTO> collectionsInfo = collectionInfoService.getAllCollectionInfo()
                .stream()
                .map(CollectionInfoDTO::new)
                .collect(Collectors.toList());

        return collectionsInfo;
    }



}
