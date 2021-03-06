package com.revature.spring_boot.services;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.CollectionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Service layer for CollectionTypes
 */
@Service
@Transactional
public class CollectionTypeService {

    private CollectionTypeRepository collectionTypeRepo;

    @Autowired
    public CollectionTypeService(CollectionTypeRepository collectionTypeRepo){
        this.collectionTypeRepo = collectionTypeRepo;
    }

    /**
     * Makes the repository call to get all CollectionTypes from the data layer
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CollectionType> getAllCollectionTypes(){return collectionTypeRepo.findAll();}


}
