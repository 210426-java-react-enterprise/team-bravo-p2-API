package com.revature.spring_boot.web.controllers;

import com.revature.spring_boot.services.DirectorService;
import com.revature.spring_boot.web.dtos.DirectorDTO;
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
 * Controller class exposing director based endpoints
 */
@RestController
@RequestMapping("/director")
public class DirectorController {

    private Logger logger = LoggerFactory.getLogger(DirectorController.class);
    private DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }

    /**
     * Gets all the persisted directors via the service layer
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-all")
    public List<DirectorDTO> getAllDirectors(){
        List<DirectorDTO> directorDTOList = directorService.getDirectorList().stream()
                .map(DirectorDTO::new)
                .collect(Collectors.toList());
        return directorDTOList;
    }

}
