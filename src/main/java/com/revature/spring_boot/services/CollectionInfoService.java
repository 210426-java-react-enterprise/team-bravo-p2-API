package com.revature.spring_boot.services;

import com.revature.spring_boot.models.CollectionInfo;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 9:56 PM
 * Description: {Insert Description}
 */

@Service
@Transactional
public class CollectionInfoService {

    private CollectionInfoRepository collectionInfoRepo;

    @Autowired
    public CollectionInfoService(CollectionInfoRepository collectionInfoRepo){
        this.collectionInfoRepo = collectionInfoRepo;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CollectionInfo> getAllCollectionInfo() {
        return collectionInfoRepo.findAll();
    }



}
