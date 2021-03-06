package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.ResourceNotFoundException;
import com.revature.spring_boot.models.CollectionInfo;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;
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
 * Description: Service layer for validating and persisting CollectionInfo
 */

@Service
@Transactional
public class CollectionInfoService {

    private CollectionInfoRepository collectionInfoRepo;

    @Autowired
    public CollectionInfoService(CollectionInfoRepository collectionInfoRepo){
        this.collectionInfoRepo = collectionInfoRepo;
    }

    /**
     * makes the repo call to delete a collection absed on ID
     * @param collectionId
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteCollectionById(int collectionId) {
        CollectionInfo existingCollection = collectionInfoRepo.findById(collectionId)
                .orElseThrow(() -> new ResourceNotFoundException());
            collectionInfoRepo.delete(existingCollection);
    }

    /**
     * Repository call to list all collections
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CollectionInfo> getAllCollectionInfo() {
        return collectionInfoRepo.findAll();
    }

    /**
     * Repository call to save a new collection
     * @param collectionInfo
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public CollectionInfo saveCollectionInfo(CollectionInfoDTO collectionInfo){

        CollectionInfo collectionInfoModel = new CollectionInfo(collectionInfo);
        collectionInfoRepo.save(collectionInfoModel);
        return collectionInfoModel;
    }
    //map dto to persistent entity

//    @Transactional(propagation = Propagation.REQUIRED)
//    public AppUser register(AppUser newUser) throws InvalidRequestException, ResourcePersistenceException {
//
//        isUserValid(newUser);
//
//        if (isUsernameAvailable(newUser.getUsername())) {
//            throw new ResourcePersistenceException("Provided username is already taken!");
//        }
//
//        if (isEmailAvailable(newUser.getEmail())) {
//            throw new ResourcePersistenceException("Provided email is already taken!");
//        }
//
//        newUser.setRole(AppUser.Role.BASIC_USER);
//        return userRepo.save(newUser);
//    }



}
