package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.services.ActorService;
import com.revature.spring_boot.services.CollectionInfoService;
import com.revature.spring_boot.web.dtos.ActorDTO;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 8:44 AM
 * Description: {Insert Description}
 */

@RestController
@RequestMapping("/actors")
public class ActorController {

    private Logger logger = LoggerFactory.getLogger(ActorController.class);
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-all")
    public List<ActorDTO> getAllCollections() {

        List<ActorDTO> actors = actorService.getAllActors()
                .stream()
                .map(ActorDTO::new)
                .collect(Collectors.toList());

        return actors;
    }

}
