package com.revature.spring_boot.controllers;

import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.CollectionTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/collection")
public class CollectionInfoController {

    private Logger logger = LoggerFactory.getLogger(CollectionType.class);
    private CollectionTypeRepository collectionTypeRepo;
    private CollectionInfoRepository collectionInfoRepo;

    @Autowired
    public CollectionInfoController(CollectionInfoRepository collectionInfoRepo, CollectionTypeRepository collectionTypeRepo){
        this.collectionTypeRepo = collectionTypeRepo;
        this.collectionInfoRepo = collectionInfoRepo;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAll")
    public List<CollectionInfo> getAllCollections() { return collectionInfoRepo.findAll();}

//    @PostMapping()




}
