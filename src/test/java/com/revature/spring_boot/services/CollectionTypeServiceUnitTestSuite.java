package com.revature.spring_boot.services;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.repos.CollectionTypeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class CollectionTypeServiceUnitTestSuite {
    private CollectionTypeService sut;
    private CollectionTypeRepository mockCollectionTypeRepo;


    @Before
    public void setUp(){
        mockCollectionTypeRepo = mock(CollectionTypeRepository.class);
        sut = new CollectionTypeService(mockCollectionTypeRepo);
    }

    @After
    public void tearDown(){
        sut = null;
        mockCollectionTypeRepo = null;
    }

    @Test
    public void test_getAllCollectionInfo(){
        List<CollectionType> collectionType = new ArrayList<>();
        when(mockCollectionTypeRepo.findAll()).thenReturn(collectionType);
        sut.getAllCollectionTypes();
    }
}
