package com.revature.spring_boot.services;

import com.revature.spring_boot.models.Director;
import com.revature.spring_boot.repos.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for validating and persisting DirectorService
 */
@Service
@Transactional
public class DirectorService {

    private DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    /**
     * Makes the repository call to list all directors from the data layer
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Director> getDirectorList(){
        return directorRepository.findAll();
    }

}
