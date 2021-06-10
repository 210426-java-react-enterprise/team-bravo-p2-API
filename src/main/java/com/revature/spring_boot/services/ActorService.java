package com.revature.spring_boot.services;

import com.revature.spring_boot.models.Actor;
import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.repos.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 8:34 AM
 * Description: {Insert Description}
 */

@Service
@Transactional
public class ActorService {

    private ActorRepository actorRepo;

    @Autowired
    public ActorService(ActorRepository actorRepo){
        this.actorRepo = actorRepo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Actor> getAllActors() {
        return actorRepo.findAll();
    }

}
