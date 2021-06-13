package com.revature.spring_boot.services;

import com.revature.spring_boot.models.CollectionInfo;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.repos.UserRepository;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class CollectionInfoServiceUnitTestSuite {
    private CollectionInfoService sut;
    private CollectionInfoRepository mockCollectionInfoRepo;


    @Before
    public void setUp(){
        mockCollectionInfoRepo = mock(CollectionInfoRepository.class);
        sut = new CollectionInfoService(mockCollectionInfoRepo);
    }

    @After
    public void tearDown(){
        sut = null;
        mockCollectionInfoRepo = null;
    }

    @Test
    public void test_getAllCollectionInfo(){
        List<CollectionInfo> collectionInfo = new ArrayList<>();
        when(mockCollectionInfoRepo.findAll()).thenReturn(collectionInfo);
        sut.getAllCollectionInfo();
    }

    @Test
    public void test_saveCollectionInfo(){
        CollectionInfoDTO collectionInfoModel = new CollectionInfoDTO();
        CollectionInfo collectionInfo = new CollectionInfo(collectionInfoModel);
        sut.saveCollectionInfo(collectionInfoModel);
    }

}
