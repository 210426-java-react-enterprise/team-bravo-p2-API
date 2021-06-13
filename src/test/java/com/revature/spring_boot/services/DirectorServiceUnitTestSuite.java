package com.revature.spring_boot.services;

import com.revature.spring_boot.models.CollectionType;
import com.revature.spring_boot.models.Director;
import com.revature.spring_boot.repos.DirectorRepository;
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
public class DirectorServiceUnitTestSuite {
    DirectorService sut;
    DirectorRepository mockDirectorRepo;


    @Before
    public void setUp(){
        mockDirectorRepo = mock(DirectorRepository.class);
        sut = new DirectorService(mockDirectorRepo);
    }

    @After
    public void tearDown(){
        sut = null;
        mockDirectorRepo = null;
    }

    @Test
    public void test_getAllCollectionInfo(){
        List<Director> directors  = new ArrayList<>();
        when(mockDirectorRepo.findAll()).thenReturn(directors);
        sut.getDirectorList();
    }

}
